package me.example.test.evnts;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:43
 * @Version 1.0
 * @Desc 待支付订单事件对象
 */
public class PayOrderEvent extends AbstractOrderEvent {


    public PayOrderEvent(OrderStatusEnum orderStatusEnum, OrderBizTypeEnum orderBizTypeEnum, Object source) {
        super(orderBizTypeEnum, orderStatusEnum, source);
    }
}
