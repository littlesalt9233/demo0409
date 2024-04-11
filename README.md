# demo0409
# 简要说明
*基于事件驱动 + 策略模式 + 模板模式 实现状态和业务解耦*
# 目录说明
```
//
└─src
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
