package com.example.test.strategy.strategyImpl;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.evnts.CompletelyOrderEvent;
import com.example.test.logAop.TraceLog;
import com.example.test.strategy.OrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:33
 * @Version 1.0
 * @Desc some description
 */
@Component
public class HotelOrderStrategyImpl implements OrderStrategy {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 酒店订单处理
     * @param orderStatusEnum 订单状态
     */
    @Override
    @TraceLog(traceName = "HotelOrderStrategyImpl",threadLog = "进入酒店订单处理")
    public void process(OrderStatusEnum orderStatusEnum) {
        // 酒店订单支付前的检查 ......
        // 信用支付
        // 如果支付失败关闭订单
        System.out.println("进入酒店订单处理策略");
        
        switch (orderStatusEnum){
            case STATUS_1:
                System.out.println("处理待支付酒店订单");
                System.out.println("酒店订单支付成功");
                // 模拟支付成功MQ消息发布
                eventPublisher.publishEvent(new CompletelyOrderEvent(OrderBizTypeEnum.HOTEL,OrderStatusEnum.STATUS_2,this));
                break;
            case STATUS_2:
                System.out.println("处理完成的酒店订单");
                break;
            default:
                break;
        }

        }
}
