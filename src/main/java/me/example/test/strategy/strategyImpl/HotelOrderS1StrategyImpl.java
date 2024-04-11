package me.example.test.strategy.strategyImpl;

import me.example.test.aop.TraceLog;
import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.evnts.PayOrderEvent;
import me.example.test.model.OrderInfo;
import me.example.test.strategy.EventStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:33
 * @Version 1.0
 * @Desc 酒店 待支付订单处理方法
 */
@Component(OrderStatusEnum.Name.s1 + OrderBizTypeEnum.Name.HOTEL)
public class HotelOrderS1StrategyImpl implements EventStrategy<PayOrderEvent> {



    /**
     * 事件策略处理
     * @param event 事件
     */
    @Override
    @TraceLog(traceName = "HotelOrderStrategyImpl", threadLog = "处理待支付酒店订单")
    public void process(PayOrderEvent event) {
        // 酒店订单支付前的检查 ......
        // 信用支付
        // 如果支付失败关闭订单
        System.out.println("酒店订单支付成功");
        //event.getContext() 获取事件上下文
        OrderInfo orderInfo = event.getContext();
        System.out.println(orderInfo);

    }
}
