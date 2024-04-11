package me.example.test.strategy.strategyImpl;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.aop.TraceLog;
import me.example.test.strategy.OrderBizStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:33
 * @Version 1.0
 * @Desc 签证 已完成订单处理方法
 */
@Component(OrderStatusEnum.Name.s2 + OrderBizTypeEnum.Name.VISA)
public class VisaOrderS2StrategyImpl implements OrderBizStrategy {
    @Override
    @TraceLog(traceName = "VisaOrderS2StrategyImpl", threadLog = "处理完成的visa订单")
    public void process(OrderStatusEnum orderStatusEnum) {

    }
}
