package me.example.test.service;

import me.example.test.model.OrderInfo;

/**
 * 支付服务类 (方便候选人本地阅读代码, 不需要动)
 */
public interface PayService {

    /**
     * 信用支付
     * @param orderInfo
     */
    long payOfCredit(OrderInfo orderInfo);
    /**
     * 支付宝支付
     * @param orderInfo
     */
    long payOfAliPay(OrderInfo orderInfo);

    /**
     * 未支付成功后关闭
     * @param orderInfo
     */
    void notPayedToClose(OrderInfo orderInfo) ;
}
