package me.example.test.strategy;

import me.example.test.enums.OrderBizTypeEnum;

import me.example.test.enums.OrderStatusEnum;
import me.example.test.evnts.AbstractEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 订单策略处理器
 *
 * @author chenjw
 */

@Component
public class OrderProcessor {

    @Autowired
    private Map<String, OrderBizStrategy> strategies;

    /**
     * @param orderBizType    业务类型
     * @param orderStatusEnum 订单状态
     * @Desc 订单处理器
     */
    public void processOrder(OrderStatusEnum orderStatusEnum, OrderBizTypeEnum orderBizType) {
        OrderBizStrategy strategy = strategies.get(orderStatusEnum.name() + orderBizType.getStrategy());
        if (strategy != null) {
            strategy.process(orderStatusEnum);
        } else {
            System.out.println("No processing strategy found for the given status and biz type.");
        }
    }

    public void processOrder(AbstractEvent event) {
        OrderBizStrategy strategy = strategies.get(orderStatusEnum.name() + orderBizType.getStrategy());
        if (strategy != null) {
            strategy.process(orderStatusEnum);
        } else {
            System.out.println("No processing strategy found for the given status and biz type.");
        }
    }
}