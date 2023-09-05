package com.sea.weed.module.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sea.weed.model.TestModel;

@Mapper
public interface TestMapper {
    
    List<TestModel> selectModel();
}
