package me.example.test.service.impl;

import me.example.test.model.OrderInfo;
import me.example.test.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderInfo getOrderInfo(String orderNo) {
        return new OrderInfo();
    }

    @Override
    public void updateOrderStatus(String orderNo, int status) {
        // 更新订单逻辑
    }
}
