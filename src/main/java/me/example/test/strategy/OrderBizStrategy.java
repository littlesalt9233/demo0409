package com.example.test.strategy;

import com.example.test.enums.OrderStatusEnum;


/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date  2024/4/10 11:42
 * @Version 1.0
 * @Desc 订单业务策略
*/
public interface OrderBizStrategy {

    /**
     *
     * @param orderStatusEnum 订单状态
     */
    void process(OrderStatusEnum orderStatusEnum);
}
