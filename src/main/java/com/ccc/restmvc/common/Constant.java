package com.ccc.restmvc.common;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

public class Constant {

	public static ConcurrentHashMap<String, HttpSession> MEMORY_CACHE = new ConcurrentHashMap<String, HttpSession>(500);

}
