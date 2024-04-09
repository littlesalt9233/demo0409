package com.example.test.enums;


/**
 * 订单类型枚举
 * */
public enum OrderBizTypeEnum {
    /**酒店订单*/
    HOTEL("hotel","酒店订单","hotelOrderStrategyImpl"),
    /**门票订单*/
    TICKETS("tickets","门票订单","ticketsOrderStrategyImpl"),
    /**签证订单*/
    VISA("visa","签证订单","visaOrderStrategyImpl"),
    ;
    private String orderType;
    private String orderDesc;
    private String strategy;

    OrderBizTypeEnum(String orderType, String orderDesc, String strategy) {
        this.orderType = orderType;
        this.orderDesc = orderDesc;
        this.strategy = strategy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    // 新增方法：根据value获取枚举成员
    public static OrderBizTypeEnum getByValue(String value) {
        for (OrderBizTypeEnum type : values()) {
            if (type.getOrderType() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}