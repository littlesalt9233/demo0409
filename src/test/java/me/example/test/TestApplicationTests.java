package me.example.test;

import me.example.test.enums.OrderBizTypeEnum;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.evnts.CompletelyOrderEvent;
import me.example.test.evnts.PayOrderEvent;
import me.example.test.model.OrderInfo;
import me.example.test.strategy.EventProcessor;
import org.aspectj.weaver.ast.Or;
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
    private ApplicationEventPublisher eventPublisher;

    /**
     * spring事件测试
     */
    @Test
    void testSpringEvent() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderBizType("hotel");
        orderInfo.setStatus(1);
        OrderStatusEnum status = OrderStatusEnum.getByValue(orderInfo.getStatus());
        switch (status) {
            case s1:
                //发布事件  创建，待支付执行支付
                eventPublisher.publishEvent(new PayOrderEvent(orderInfo, this));
                break;
            case s2:
                //发布事件 订单完成
                eventPublisher.publishEvent(new CompletelyOrderEvent(orderInfo, this));
                break;
            default: //其他事件
                break;
        }
    }

    /**
     * spring完成事件测试
     */
    @Test
    void testSpringEvent2() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderBizType("visa");
        orderInfo.setStatus(2);

        //发布事件 订单完成
        eventPublisher.publishEvent(new CompletelyOrderEvent(orderInfo, this));

    }


}
