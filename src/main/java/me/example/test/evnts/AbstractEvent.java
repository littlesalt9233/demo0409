package me.example.test.evnts;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Author: chenjw
 * Email: chixe9233@163.com
 * Date:  2024/4/11 15:04
 * Version: 1.0
 * Desc: 顶层事件抽象
*/
@Getter
public abstract class AbstractEvent<T> extends ApplicationEvent {

    /**
     * 事件上下文
     * */
    private final T context;

    /**
     * 事件名称
     * */
    private final String eventName;

    /**
     * @param context 事件上下文
     * @param source 事件对象
     * */
    public AbstractEvent(String eventName,T context,Object source) {
        super(source);
        this.eventName = eventName;
        this.context = context;
    }

}
