package com.example.test.evnts;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:43
 * @Version 1.0
 * @Desc 待支付订单事件对象
 */
public class PayOrderEvent extends AbstractOrderEvent {


    public PayOrderEvent(OrderBizTypeEnum orderBizTypeEnum, OrderStatusEnum orderStatusEnum, Object source) {
        super(orderBizTypeEnum, orderStatusEnum,source);
    }
}
