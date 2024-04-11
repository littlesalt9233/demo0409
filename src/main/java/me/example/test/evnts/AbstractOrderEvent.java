package me.example.test.evnts;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import org.springframework.context.ApplicationEvent;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 14:44
 * @Version 1.0
 * @Desc 订单抽象业务
 */
public abstract class AbstractOrderEvent extends ApplicationEvent {

    /**
     * 订单业务类型{@link OrderBizTypeEnum }
     * */
    private final OrderBizTypeEnum orderBizTypeEnum;

    /**
     * 订单状态 {@link OrderStatusEnum }
     * */
    private final OrderStatusEnum orderStatusEnum;

    public AbstractOrderEvent(OrderBizTypeEnum orderBizTypeEnum,OrderStatusEnum orderStatusEnum, Object source) {
        super(source);
        this.orderBizTypeEnum = orderBizTypeEnum;
        this.orderStatusEnum = orderStatusEnum;
    }

    /**
     * 获取定位业务枚举方法
     * @return OrderBizTypeEnum 订单业务枚举
     */
    public OrderBizTypeEnum getOrderBizTypeEnum() {
        return this.orderBizTypeEnum;
    }

    /**
     * 获取定位业务枚举方法
     * @return OrderStatusEnum 订单状态枚举
     */
    public OrderStatusEnum getOrderStatusEnum() {
        return this.orderStatusEnum;
    }



}
