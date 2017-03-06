package com.blossom.web.dao.impl;

import com.blossom.web.dao.IUserDao;
import com.blossom.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Blossom
 * @Description 用户dao接口实现
 * @time 2017/3/6 23:18
 */
@Repository("userDao")
public class UserDaoImpl  implements IUserDao{

    @Autowired
    private UserMapper userMapper;


}
