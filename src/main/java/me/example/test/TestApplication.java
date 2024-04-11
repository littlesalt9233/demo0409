package me.example.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
//@ComponentScan(basePackages = {"me.example.test.*"})
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }



}
