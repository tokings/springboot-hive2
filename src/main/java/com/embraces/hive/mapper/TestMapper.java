/**
 * Copyright 2018
 * All Right Reserved
 * Author：sherlyxiao
 * Create Date：Feb 6, 2018
 */
package com.embraces.hive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.embraces.hive.model.Test;

@Mapper
public interface TestMapper {

    List<Test> listByRowkey(@Param("rowkey") String rowkey);

    List<Test> listByRowkey2(@Param("rowkey") String rowkey);
    
    List<Test> listByRowkeys(List<String> rowkeys);

    List<Test> listByRowkeys2(List<String> rowkeys);
}
