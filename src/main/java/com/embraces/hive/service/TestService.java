/**
 * Copyright 2018
 * All Right Reserved
 * Author：sherlyxiao
 * Create Date：Feb 6, 2018
 */
package com.embraces.hive.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.embraces.hive.mapper.TestMapper;
import com.embraces.hive.model.Test;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> listByRowkey(String rowkey) {
        return testMapper.listByRowkey(rowkey);
    }
    
    public List<Test> listByRowkey2(String rowkey) {
    	return testMapper.listByRowkey2(rowkey);
    }
    
    public List<Test> listByRowkeys(List<String> rowkeys) {
    	return testMapper.listByRowkeys(rowkeys);
    }
    
    public List<Test> listByRowkeys2(List<String> rowkeys) {
    	return testMapper.listByRowkeys2(rowkeys);
    }
    
}
