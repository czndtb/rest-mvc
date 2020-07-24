package com.ccc.restmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccc.restmvc.entity.PostBody;
import com.ccc.restmvc.entity.User;
import com.ccc.restmvc.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("test")
@Api(value = "test", tags = { "TAG" })

public class TestController {

	@Autowired
	private UserService userService;

	@PostMapping("post")
	@ApiOperation(value = "post")
	public String postMethod(@Valid @RequestBody PostBody postBody) {
		return "ok";
	}

	@GetMapping("get")
	public String getMethod(@RequestParam(required = true) Integer id) {
		return "ok";
	}

	@GetMapping("get/{id}")
	public User getPathMethod(@PathVariable Integer id) {
		return userService.getById(id);
	}

}
