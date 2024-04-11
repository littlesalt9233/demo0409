package me.example.test.model;

import lombok.Getter;
import lombok.Setter;
import me.example.test.enums.OrderStatusEnum;

/**
 * 订单类 (方便候选人本地阅读代码, 不需要动)
 */
@Setter
@Getter
public class OrderInfo {
    private String orderNo;

    /**
     * 订单状态 {@link OrderStatusEnum }
     *
     * -- GETTER --
     *  获取定位业务枚举方法
     *
     * @return OrderStatusEnum 订单状态枚举
     */
    private String orderBizType;

    /**
     * 订单状态 {@link OrderStatusEnum }
     *
     * -- GETTER --
     *  获取定位业务枚举方法
     *
     * @return OrderStatusEnum 订单状态枚举
     */
    private int status;
    private String anything;

}
