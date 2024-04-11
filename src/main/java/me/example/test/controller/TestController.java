package me.example.test.controller;

import me.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * @Desc 数据库通联接口
     */
    @GetMapping("/t1")
    public String t1(){
        testService.test1();
        return "OK";
    }
}
