package com.example.test.evnts.listener;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.evnts.CompletelyOrderEvent;
import com.example.test.strategy.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 14:31
 * @Version 1.0
 * @Desc 订单完成事件监听器
 */
@Component
public class CompletelyOrderEventListener implements ApplicationListener<CompletelyOrderEvent> {

    @Autowired
    private OrderProcessor orderProcessor;

    @Override
    public void onApplicationEvent(CompletelyOrderEvent completelyOrderEvent) {
        System.out.println("监听器接收订单完成事件...");
        OrderBizTypeEnum bizTypeEnum = completelyOrderEvent.getOrderBizTypeEnum();
        OrderStatusEnum statusEnum = completelyOrderEvent.getOrderStatusEnum();
        orderProcessor.processOrder(bizTypeEnum,statusEnum);
    }
}
