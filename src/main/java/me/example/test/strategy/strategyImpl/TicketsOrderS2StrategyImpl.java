package me.example.test.strategy.strategyImpl;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.aop.TraceLog;
import me.example.test.evnts.CompletelyOrderEvent;
import me.example.test.strategy.EventStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date  2024/4/10 9:37
 * @Version 1.0
 * @Desc some description
*/
@Component(OrderStatusEnum.Name.s2 + OrderBizTypeEnum.Name.TICKETS)
public class TicketsOrderS2StrategyImpl implements EventStrategy<CompletelyOrderEvent> {

    @Override
    @TraceLog(traceName = "HotelOrderStrategyImpl", threadLog = "处理已完成门票订单")
    public void process(CompletelyOrderEvent event) {

    }
}
