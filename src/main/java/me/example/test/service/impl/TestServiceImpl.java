package com.example.test.service.impl;

import com.example.test.dao.TestDao;
import com.example.test.logAop.TraceLog;
import com.example.test.model.TestPojo;
import com.example.test.service.TestService;
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
