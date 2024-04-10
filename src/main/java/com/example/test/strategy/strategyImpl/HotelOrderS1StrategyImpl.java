package com.example.test.strategy.strategyImpl;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.evnts.CompletelyOrderEvent;
import com.example.test.logAop.TraceLog;
import com.example.test.strategy.OrderBizStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:33
 * @Version 1.0
 * @Desc 酒店 待支付订单处理方法
 */
@Component(OrderStatusEnum.Name.s1 + OrderBizTypeEnum.Name.HOTEL)
public class HotelOrderS1StrategyImpl implements OrderBizStrategy {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 酒店订单处理
     *
     * @param orderStatusEnum 订单状态
     */
    @Override
    @TraceLog(traceName = "HotelOrderStrategyImpl", threadLog = "处理待支付酒店订单")
    public void process(OrderStatusEnum orderStatusEnum) {
        // 酒店订单支付前的检查 ......
        // 信用支付
        // 如果支付失败关闭订单
        System.out.println("酒店订单支付成功");
        eventPublisher.publishEvent(new CompletelyOrderEvent(OrderBizTypeEnum.HOTEL, OrderStatusEnum.s2, this));


    }
}
