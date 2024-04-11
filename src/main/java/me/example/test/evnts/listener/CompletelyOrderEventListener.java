package me.example.test.evnts.listener;

import me.example.test.evnts.CompletelyOrderEvent;
import me.example.test.strategy.EventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 14:31
 * @Version 1.0
 * @Desc 订单完成事件监听器
 */
@Component
public class CompletelyOrderEventListener implements ApplicationListener<CompletelyOrderEvent> {

    @Autowired
    private EventProcessor<CompletelyOrderEvent> orderProcessor;

    @Override
    //适配器模式
    public void onApplicationEvent(CompletelyOrderEvent completelyOrderEvent) {
        System.out.println("监听器接收订单完成事件...");
        orderProcessor.processOrder(completelyOrderEvent);
    }
}
