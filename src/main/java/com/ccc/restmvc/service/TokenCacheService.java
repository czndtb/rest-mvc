package com.ccc.restmvc.service;

import javax.servlet.http.HttpSession;

/**
 * TODO 缓存token的service
 * 
 * @author Administrator
 *
 */
public interface TokenCacheService {

	/**
	 * TODO 设置token
	 * 
	 * @param session session信息
	 * @param expr    过期时间
	 */
	public void setToken(String token, HttpSession session, long expr);


	public String getToken(String token);
}
