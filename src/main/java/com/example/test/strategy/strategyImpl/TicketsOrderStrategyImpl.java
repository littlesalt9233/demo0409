package com.example.test.strategy.strategyImpl;

import com.example.test.enums.OrderStatusEnum;
import com.example.test.strategy.OrderStrategy;
/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date  2024/4/10 9:37
 * @Version 1.0
 * @Desc some description
*/
public class TicketsOrderStrategyImpl  implements OrderStrategy {
    @Override
    public void process(OrderStatusEnum orderStatusEnum) {
//        long payId = -1;
//        for (int i = 0; i < 3; i++) { // 如果失败有3次重试
//            // 信用支付
//            payId = payService.payOfCredit(orderInfo);
//            // payId >0 代表支付成功
//            if (payId > 0) {
//                break;
//            }
//        }
//        // 如果支付失败关闭订单
//        if(payId < 0) {
//            payService.notPayedToClose(orderInfo);
//        }
//
    }
}
