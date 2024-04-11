package me.example.test.enums;


import lombok.Getter;

import java.util.Objects;

/**
 * 订单类型枚举
 */
@Getter
public enum OrderBizTypeEnum {
    /**
     * 酒店订单
     */
    HOTEL("hotel", "酒店订单", "hotelOrderStrategyImpl"),
    /**
     * 门票订单
     */
    TICKETS("tickets", "门票订单", "ticketsOrderStrategyImpl"),
    /**
     * 签证订单
     */
    VISA("visa", "签证订单", "visaOrderStrategyImpl"),
    ;
    private final String orderType;
    private final String orderDesc;
    private final String strategy;

    OrderBizTypeEnum(String orderType, String orderDesc, String strategy) {
        this.orderType = orderType;
        this.orderDesc = orderDesc;
        this.strategy = strategy;
    }


    // 新增方法：根据value获取枚举成员
    public static OrderBizTypeEnum getByValue(String value) {
        for (OrderBizTypeEnum type : values()) {
            if (Objects.equals(type.getOrderType(), value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }


    public static class Name{
        public static final String HOTEL = "hotelOrderStrategyImpl";
        public static final String TICKETS = "ticketsOrderStrategyImpl";
        public static final String VISA = "visaOrderStrategyImpl";
    }
}