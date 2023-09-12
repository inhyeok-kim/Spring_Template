package com.sea.weed.module.auth;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sea.weed.model.TestModel;

@Mapper
public interface AuthMapper {
    
    List<TestModel> selectModel();
}
