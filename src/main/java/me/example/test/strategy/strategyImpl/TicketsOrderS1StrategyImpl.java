package me.example.test.strategy.strategyImpl;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.aop.TraceLog;
import me.example.test.strategy.OrderBizStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date  2024/4/10 9:37
 * @Version 1.0
 * @Desc 门票 待支付订单处理方法
*/
@Component(OrderStatusEnum.Name.s1 + OrderBizTypeEnum.Name.TICKETS)
public class TicketsOrderS1StrategyImpl implements OrderBizStrategy {
    @Override
    @TraceLog(traceName = "HotelOrderStrategyImpl", threadLog = "处理待支付门票订单")
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
