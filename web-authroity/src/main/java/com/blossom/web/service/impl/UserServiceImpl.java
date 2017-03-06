package com.blossom.web.service.impl;

import com.blossom.web.dao.IUserDao;
import com.blossom.web.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Blossom
 * @Description 用户Service接口实现
 * @time 2017/3/6 23:23
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

}
