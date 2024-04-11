package me.example.test.service;

import me.example.test.model.OrderInfo;

/**
 * 订单服务类 (方便候选人本地阅读代码, 不需要动)
 */
public interface OrderService {
    OrderInfo getOrderInfo(String orderNo);
    void updateOrderStatus(String orderNo, int status);

}
