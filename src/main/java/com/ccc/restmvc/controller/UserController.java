package com.ccc.restmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@PostMapping("auth/login")
	public String login(HttpServletRequest request) {
		
		request.getSession();
		
		return "";
	}
	
}
