package com.ccc.restmvc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccc.restmvc.entity.User;
import com.ccc.restmvc.mapper.UserMapper;
import com.ccc.restmvc.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
