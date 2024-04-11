package me.example.test.aop;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TraceLog {
    String traceName() default "default";

    String threadLog() default "default log";


}
