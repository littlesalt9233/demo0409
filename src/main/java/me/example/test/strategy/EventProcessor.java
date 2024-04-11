package me.example.test.strategy;

import lombok.SneakyThrows;
import me.example.test.enums.OrderBizTypeEnum;

import me.example.test.enums.OrderStatusEnum;
import me.example.test.evnts.AbstractEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 事件处理器
 *
 * @author chenjw
 */

@Component
public class EventProcessor<T extends AbstractEvent> {

    /**
     * 策略上下文
     * */
    @Autowired
    private Map<String, EventStrategy> strategies;

    /**
     * @Desc 事件处理方法
     */
    @SneakyThrows
    public void processOrder(T event) {
        //从策略上下文种获取对应的事件策略
        EventStrategy strategy = strategies.get(event.getEventName());
        if (strategy != null) {
            //调用策略处理方法
            strategy.process(event);
        } else {
            throw new RuntimeException("No processing strategy found for the given status and biz type.");
        }
    }
}