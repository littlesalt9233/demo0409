package com.example.test.strategy.strategyImpl;

import com.example.test.enums.OrderStatusEnum;
import com.example.test.strategy.OrderStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 11:33
 * @Version 1.0
 * @Desc some description
 */
@Component
public class VisaOrderStrategyImpl implements OrderStrategy {
    @Override
    public void process(OrderStatusEnum orderStatusEnum) {
        switch (orderStatusEnum){
            case STATUS_1:
                System.out.println("处理待支付visa订单");
                break;
            case STATUS_2:
                System.out.println("处理完成的visa订单");
                break;
            default:
                break;
        }

    }
}
