package com.example.test.evnts.listener;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.evnts.PayOrderEvent;
import com.example.test.strategy.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:51
 * @Version 1.0
 * @Desc 订单完成事件监听
 */
@Component
public class PayOrderEventListener implements ApplicationListener<PayOrderEvent> {

    @Autowired
    private OrderProcessor orderProcessor;

    @Override
    public void onApplicationEvent(PayOrderEvent payOrderEvent) {
        System.out.println("监听器接收待付款订单事件...");
        OrderBizTypeEnum bizTypeEnum = payOrderEvent.getOrderBizTypeEnum();
        OrderStatusEnum statusEnum = payOrderEvent.getOrderStatusEnum();
        orderProcessor.processOrder(bizTypeEnum,statusEnum);
    }
}
