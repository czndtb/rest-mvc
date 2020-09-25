package com.ccc.restmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccc.restmvc.entity.PostBody;
import com.ccc.restmvc.entity.User;
import com.ccc.restmvc.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("test")
@Api(value = "test", tags = { "TAG" })

public class TestController {

	@Autowired
	private UserService userService;

	@PostMapping("post")
	@ApiOperation(value = "post")
	public String postMethod(@ApiParam(value = "参数体") @Valid @RequestBody PostBody postBody) {
		return "ok";
	}

	@GetMapping("get")
	public String getMethod(@RequestParam(required = true) Integer id) {
		
		InputStream in = getClass().getClassLoader().getResourceAsStream("test.properties");
		
		Properties prop = new Properties();
		
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JSONObject.toJSONString(prop);
	}

	@GetMapping("get/{id}")
	public User getPathMethod(@PathVariable Integer id) {
		Page<User> page = userService.page(new Page<User>(1, 10), new QueryWrapper<User>().eq("id", 1));
		
		List<User> users = page.getRecords();
		
		long current = page.getCurrent();
		
		long total = page.getTotal();
		
		return userService.getById(id);
	}

}
