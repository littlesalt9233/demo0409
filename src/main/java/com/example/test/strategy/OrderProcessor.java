package com.example.test.strategy;

import com.example.test.enums.OrderBizTypeEnum;

import com.example.test.enums.OrderStatusEnum;
import com.example.test.logAop.TraceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 订单策略处理器
 *
 * @author chenjw
 * */

@Component
public class OrderProcessor {

    @Autowired
    private Map<String, OrderStrategy> strategies;

    /**
     *
     * @Desc 订单处理器
     * @param orderBizType  业务类型
     * @param orderStatusEnum 订单状态
     */
    @TraceLog(traceName = "adsadad")
    public void processOrder(OrderBizTypeEnum orderBizType, OrderStatusEnum orderStatusEnum) {
        OrderStrategy strategy = strategies.get(orderBizType.getStrategy());
        if (strategy != null) {
            strategy.process(orderStatusEnum);
        } else {
            System.out.println("No processing strategy found for the given status and biz type.");
        }
    }
}