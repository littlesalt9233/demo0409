package com.example.test.service;


import com.example.test.enums.OrderBizTypeEnum;

/**
 * 所有订单必须继承接口
 * */
public interface OrderTypeFlow {

    void payOrder(OrderBizTypeEnum orderTypeEnum);
}
