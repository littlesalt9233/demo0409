# demo0409
# 简要说明
*基于事件驱动 + 策略模式 + 模板模式 实现状态和业务解耦*
# 目录说明
```
src
    ├─main
    │  ├─java
    │  │  └─me
    │  │      └─example
    │  │          └─test //测试包
    │  │              ├─aop //aop注解日志实现 
    │  │              ├─controller //控制器
    │  │              ├─dao //dao层
    │  │              ├─enums //枚举类
    │  │              ├─evnts //spring事件包
    │  │              │  └─listener //spring事件监听
    │  │              ├─listener //mqListener
    │  │              ├─model //数据model对象
    │  │              ├─service //service层
    │  │              │  └─impl //service实现层
    │  │              └─strategy //策略包
    │  │                  └─strategyImpl
    │  └─resources //配置包、mapper
    │      └─mapper 
    └─test
        └─java
            └─me
                └─example
                    └─test //单元测试包
```
# 主要逻辑说明
## 类继承关系说明
```
AbstractEvent<T> extends ApplicationEvent //顶层事件抽象 包括eventName（确定事件name）、content（上下文对象容器）两个属性
    ├─OrderAbstractEvent extends AbstractEvent<OrderInfo>  //订单业务类型抽象 通过构造方法提供eventName、约定子类提供能够获取一个同样的eventName方法
    │  ├─PayOrderEvent extends OrderAbstractEvent //待支付具体事件实现 
    │  ├─CompletelyOrderEvent extends OrderAbstractEvent //完成订单具体事件实现 
    │  └─OtherOrderEvent extends OrderAbstractEvent //其他具体事件实现 
    └─OtherAbstractEvent //任意业务事件实现
        └─任意业务事件实现
                    
 ```                   
1. `AbstractEvent` 定义eventName（确定事件name）、content（上下文对象容器）并提供对应的`getter`获取事件name及上下文对象，并继承springEvent`ApplicationEvent`；
2. `OrderAbstractEvent` extends AbstractEvent<OrderInfo>抽象订单事件，通过构造方法构建eventName、content,需要确保构建eventName和`#getEventName`一致；
3. `CompletelyOrderEvent`extends OrderAbstractEvent 具体的实现类。

## 事件策略类说明
```
EventStrategy<T extends AbstractEvent> //事件策略接口，约定事件必须继承于AbstractEvent
    ├─HotelOrderS1StrategyImpl implements EventStrategy<PayOrderEvent>  //酒店订单业务 + 待支付事件策略，专注处理该事件
    ├─TicketsOrderS2StrategyImpl implements EventStrategy<CompletelyOrderEvent>  //酒店订单业务 + 待支付事件策略，专注处理该事件
    └─OtherStrategyImpl  //其他具体策略实现 
                    
 ```  

1. `EventStrategy` 定义一个含有`#process`方法的策略接口，由`xxxOrderxxxStatusStrategyImpl`实现不同的处理策略，
2. 定义`EventProcessor`将所有策略对象注入到`Map<String, OrderBizStrategy> strategies`容器中，并提供`#processOrder`方法提供策略分派逻辑；
2. 通过`AbstractOrderEvent`抽象订单事件，所有继承于此的子事件通过构造方法构建携带状态及业务类型的事件；
3. `xxxOrderEventListener`对事件实现对象进行监听，通过`#onApplicationEvent`方法寻找适配的策略实现类处理对应的业务。
## 代码流程说明
1. mq消费端根据不同的状态+业务类型发布`xxxOrderEvent`的spring事件；
2. 对应的状态事件监听器收到事件时在各自的`#onApplicationEvent`方法中取出事件携带的业务信息，利用已经注入策略上下文`OrderProcessor`,将业务委托给策略上下文执行。
## 好处&目前的缺陷
- 代码维护便利性与拓展性的提高
  - 增加状态或者业务只需要增加对应的状态事件和策略，不需要修改原有的逻辑流程
  - 在策略中只需要关注一种业务一种状态的编码专注于自己的实现而无需关心其他逻辑
- 结构性僵化
  - 目前只实现了状态+业务两种业务属性的无侵入拓展，对于增加第三种业务属性无法满足 