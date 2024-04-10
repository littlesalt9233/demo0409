package com.example.test.strategy.strategyImpl;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.logAop.TraceLog;
import com.example.test.strategy.OrderBizStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:33
 * @Version 1.0
 * @Desc 酒店 完成订单处理方法
 */
@Component(OrderStatusEnum.Name.s2 + OrderBizTypeEnum.Name.HOTEL)
public class HotelOrderS2StrategyImpl implements OrderBizStrategy {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 酒店订单处理
     *
     * @param orderStatusEnum 订单状态
     */
    @Override
    @TraceLog(traceName = "HotelOrderStrategyImpl", threadLog = "进入酒店完成订单处理")
    public void process(OrderStatusEnum orderStatusEnum) {
        // 酒店订单支付前的检查 ......
        // 信用支付
        // 如果支付失败关闭订单
    }
}
