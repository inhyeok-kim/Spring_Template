package com.sea.weed.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sea.weed.model.TestModel;

@Mapper
public interface TestMapper {
    
    List<TestModel> selectModel();
}
