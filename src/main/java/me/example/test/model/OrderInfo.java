package me.example.test.model;

import lombok.Getter;

/**
 * 订单类 (方便候选人本地阅读代码, 不需要动)
 */
@Getter
public class OrderInfo {
    private String orderNo;
    private String orderBizType;
    private int status;
    private String anything;

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setOrderBizType(String orderBizType) {
        this.orderBizType = orderBizType;
    }

    public void setAnything(String anything) {
        this.anything = anything;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
