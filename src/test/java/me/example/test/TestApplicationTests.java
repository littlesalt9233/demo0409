package me.example.test;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.evnts.CompletelyOrderEvent;
import me.example.test.evnts.PayOrderEvent;
import me.example.test.strategy.OrderProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OrderProcessor orderProcessor;

    /**
     * 策略模式测试
     */
    @Test
    void testOrder() {
        OrderBizTypeEnum visa = OrderBizTypeEnum.VISA;
        OrderStatusEnum status = OrderStatusEnum.s1;
        orderProcessor.processOrder(status, visa);
        OrderBizTypeEnum hotel = OrderBizTypeEnum.HOTEL;
        orderProcessor.processOrder(status, hotel);
    }

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * spring事件测试
     */
    @Test
    void testSpringEvent() {
        OrderStatusEnum status = OrderStatusEnum.getByValue(1);
        OrderBizTypeEnum bizType = OrderBizTypeEnum.getByValue("hotel");
        switch (status) {
            case s1:
                //发布事件  创建，待支付执行支付
                eventPublisher.publishEvent(new PayOrderEvent(status, bizType, this));
                break;
            case s2:
                //发布事件 订单完成
                eventPublisher.publishEvent(new CompletelyOrderEvent(status,bizType,  this));
                break;
            default: //其他事件
                break;
        }
    }


}
