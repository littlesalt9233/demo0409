package me.example.test.service.impl;

import me.example.test.dao.TestDao;
import me.example.test.aop.TraceLog;
import me.example.test.model.TestPojo;
import me.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @TraceLog(traceName = "test1",threadLog = "")
    public void test1() {
        ArrayList<TestPojo> list = new ArrayList<>();
        list.add(new TestPojo(1,-1,-1));
        list.add(new TestPojo(3,-2,-2));
        testDao.updateBat(list);
    }
}
