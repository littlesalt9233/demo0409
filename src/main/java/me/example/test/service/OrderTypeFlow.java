package me.example.test.service;


import me.example.test.enums.OrderBizTypeEnum;

/**
 * 所有订单必须继承接口
 * 模板模式
 * */
public interface OrderTypeFlow {

    void payOrder(OrderBizTypeEnum orderTypeEnum);
}
