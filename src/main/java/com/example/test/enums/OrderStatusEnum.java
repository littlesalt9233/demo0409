package com.example.test.enums;

// 状态枚举
public enum OrderStatusEnum {
    /**状态1*/
    STATUS_1(1),
    /**状态2*/
    STATUS_2(2);

    private int value;

    OrderStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 新增方法：根据value获取枚举成员
    public static OrderStatusEnum getByValue(int value) {
        for (OrderStatusEnum status : values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}