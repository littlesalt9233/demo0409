package com.example.test.strategy;

import com.example.test.enums.OrderStatusEnum;

/**
 * 订单策略
 * */
public interface OrderStrategy {

    /**
     *
     * @param orderStatusEnum 订单状态
     */
    void process(OrderStatusEnum orderStatusEnum);
}
