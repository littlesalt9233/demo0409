package me.example.test.service.impl;

import me.example.test.model.OrderInfo;
import me.example.test.service.PayService;

public class PayServiceImpl implements PayService {

    /**
     * 信用支付
     * @param orderInfo
     */
    @Override
    public long payOfCredit(OrderInfo orderInfo) {
        //  信用支付逻辑，候选人不用理会支付内部逻辑 ...
        return 1;
    }

    /**
     * 支付宝支付
     * @param orderInfo
     */
    @Override
    public long payOfAliPay(OrderInfo orderInfo) {
        //  支付宝支付逻辑，候选人不用理会支付内部逻辑 ...
        return 1;
    }

    /**
     * 未支付成功后关闭
     * @param orderInfo
     */
    @Override
    public void notPayedToClose(OrderInfo orderInfo) {
        //  支付宝支付逻辑，候选人不用理会支付内部逻辑 ...
    }
}
