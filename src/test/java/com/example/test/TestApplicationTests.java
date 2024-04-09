package com.example.test;

import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.evnts.CompletelyOrderEvent;
import com.example.test.evnts.PayOrderEvent;
import com.example.test.strategy.OrderProcessor;
import org.apache.catalina.core.ApplicationPushBuilder;
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
     * */
    @Test
    void testOrder() {
        OrderBizTypeEnum visa = OrderBizTypeEnum.VISA;
        OrderStatusEnum status = OrderStatusEnum.STATUS_1;
        orderProcessor.processOrder(visa,status);
        OrderBizTypeEnum hotel = OrderBizTypeEnum.HOTEL;
        orderProcessor.processOrder(hotel,status);
    }

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * spring事件测试
     * */
    @Test
    void testSpringEvent() {
        OrderStatusEnum status= OrderStatusEnum.getByValue(1);
        OrderBizTypeEnum bizType = OrderBizTypeEnum.getByValue("hotel");
        switch (status){
            case STATUS_1:
                //发布事件  创建，待支付执行支付
                eventPublisher.publishEvent(new PayOrderEvent(bizType,status,this));
                break;
            case STATUS_2:
                //发布事件 订单完成
                eventPublisher.publishEvent(new CompletelyOrderEvent(bizType,status,this));
                break;
            default: //其他事件
                break;
        }
    }


}
