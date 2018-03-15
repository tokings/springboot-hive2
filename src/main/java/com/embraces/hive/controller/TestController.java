package com.embraces.hive.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embraces.hive.model.Test;
import com.embraces.hive.service.TestService;

@RestController
@RequestMapping("/hive")
public class TestController {

	@Resource
	private TestService testService;
	
	@RequestMapping("/listByRowkey")
	public List<Test> listByRowkey(String rowKey) {
		
		return testService.listByRowkey(rowKey);
	}
	
	@RequestMapping("/listByRowkey2")
	public List<Test> listByRowkey2(String rowKey) {
		
		return testService.listByRowkey2(rowKey);
	}
	
	@RequestMapping("/listByRowkeys")
	public List<Test> listByRowkeys(String rowKeys) {
		
		return testService.listByRowkeys(Arrays.asList(rowKeys.split("[ ,]+")));
	}
	
	@RequestMapping("/listByRowkeys2")
	public List<Test> listByRowkeys2(String rowKeys) {
		
		return testService.listByRowkeys2(Arrays.asList(rowKeys.split("[ ,]+")));
	}
}
