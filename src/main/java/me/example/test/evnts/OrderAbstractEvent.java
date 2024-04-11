package me.example.test.evnts;

import lombok.Getter;
import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.model.OrderInfo;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 14:44
 * @Version 1.0
 * @Desc 订单抽象业务
 */
@Getter
public abstract class AbstractOrderEvent extends AbstractEvent<OrderInfo> {

    /**
     * 需要自己构造事件名称
     *
     * @param orderInfo 业务对象
     * @param source    事件对象
     */
    public AbstractOrderEvent(String eventName, OrderInfo orderInfo, Object source) {
        super(eventName, orderInfo, source);
    }

    /**
     * 获取事件名称
     */
    public String getEventName(me.example.test.model.OrderInfo orderInfo){
       return OrderStatusEnum.getByValue(orderInfo.getStatus()).name() + OrderBizTypeEnum.getByValue(orderInfo.getOrderBizType()).getStrategy();
    }


}
