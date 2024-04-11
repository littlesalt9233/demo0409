package me.example.test.dao;

import me.example.test.model.TestPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface TestDao extends BaseMapper<TestPojo> {

    void updateBat(@Param("list") List<TestPojo> list);
}
