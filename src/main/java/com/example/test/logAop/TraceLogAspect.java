package com.example.test.logAop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;



@Aspect
@Component
@Slf4j
public class TraceLogAspect {

//    private static final ThreadLocal<StringBuffer> traceLogHolder = new ThreadLocal<>();  //todo 改进为ThreadLocal存储日志在线程完毕同一打印


    @SneakyThrows
    @Around("@annotation(TraceLog)")
    public Object interceptor(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        String params = joinPoint.getArgs().length == 0 ? "" : Arrays.toString(joinPoint.getArgs());

        // 获取注解中的logStr属性
        TraceLog traceLog = signature.getMethod().getAnnotation(TraceLog.class);

        // 打印方法签名和入参，以及自定义的日志内容
        //可以拓展traceId 方法签名等
       log.info("Entering method: " + className + "." + methodName + "(" + params + ")" + traceLog.threadLog());
        Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Exception e) {
            log.error("catch some exception {}" , e.getMessage());
            throw e;
        }
        return proceed;
    }

}