package me.example.test.evnts;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.model.OrderInfo;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:46
 * @Version 1.0
 * @Desc 完成订单事件对象
 */
public class CompletelyOrderEvent extends OrderAbstractEvent {


    /**
     *
     * */
    public CompletelyOrderEvent(OrderInfo orderInfo, Object source) {
        super(OrderStatusEnum.getByValue(orderInfo.getStatus()).name() + OrderBizTypeEnum.getByValue(orderInfo.getOrderBizType()).getStrategy()
                ,orderInfo, source);
    }
}
