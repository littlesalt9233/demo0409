package com.example.test.evnts;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:46
 * @Version 1.0
 * @Desc 完成订单事件对象
 */
public class CompletelyOrderEvent extends AbstractOrderEvent{


    public CompletelyOrderEvent(OrderBizTypeEnum orderBizTypeEnum, OrderStatusEnum orderStatusEnum, Object source) {
        super(orderBizTypeEnum, orderStatusEnum, source);
    }
}
