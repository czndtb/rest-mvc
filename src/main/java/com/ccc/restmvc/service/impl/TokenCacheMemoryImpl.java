package com.ccc.restmvc.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ccc.restmvc.common.Constant;
import com.ccc.restmvc.service.TokenCacheService;

/**
 * TODO 内存实现token缓存
 * @author Administrator
 *
 */
@Service
@Profile(value = { "dev" })//仅仅开发环境使用
public class TokenCacheMemoryImpl implements TokenCacheService{

	@Override
	public void setToken(String token, HttpSession session, long expr) {
		
		String [][] array = new String[1][1];
		
		System.out.println(JSONObject.toJSONString(array));
		
		Constant.MEMORY_CACHE.put(token, session);
		
	}

	@Override
	public String getToken(String token) {
		Constant.MEMORY_CACHE.get(token);
		return null;
	}

}
