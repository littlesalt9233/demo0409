package me.example.test.strategy;

import lombok.SneakyThrows;
import me.example.test.enums.OrderStatusEnum;
import me.example.test.evnts.AbstractEvent;


/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date  2024/4/10 11:42
 * @Version 1.0
 * @Desc 事件策略
*/
public interface EventStrategy<T extends AbstractEvent> {

    /**
     *
     * @param event 事件
     */
    void process(T event);
}
