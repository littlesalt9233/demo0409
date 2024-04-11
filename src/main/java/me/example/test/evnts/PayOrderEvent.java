package me.example.test.evnts;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.model.OrderInfo;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:43
 * @Version 1.0
 * @Desc 待支付订单事件对象
 */
public class PayOrderEvent extends OrderAbstractEvent {


    public PayOrderEvent(OrderInfo orderInfo, Object source) {
        super(OrderStatusEnum.getByValue(orderInfo.getStatus()).name() + OrderBizTypeEnum.getByValue(orderInfo.getOrderBizType()).getStrategy()
                ,orderInfo, source);
    }

}
