package com.blossom.web.dao.impl;

import com.blossom.web.dao.IUserDao;
import com.blossom.web.mapper.UserMapper;
import com.blossom.web.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户dao接口实现
 * @time 2017/3/6 23:18
 */
@Repository("userDao")
public class UserDaoImpl  implements IUserDao{

    @Autowired
    private UserMapper userMapper;


    /**
     * @description 获取全部的用户
     * @author Blossom
     * @DateTime 2017/3/8 10:15
     */
    @Override
    public List<UserEntity> queryAllUserInfo() {
        Map<String,Object> map = new HashMap<>();
        map.put("loginAccount","");
        return userMapper.queryUserInfo(map);
    }

    /**
     * @param pMap
     * @description 获取指定的用户
     * @author Blossom
     * @DateTime 2017/3/8 10:15
     */
    @Override
    public UserEntity queryOneUserInfo(Map<String, Object> pMap) {
        List<UserEntity> userEntities = userMapper.queryUserInfo(pMap);
        if (null == userEntities || userEntities.isEmpty() || userEntities.size() == 0 || userEntities.size() > 1){
            return null;
        }
        return userEntities.get(0);
    }

    /**
     * @param user
     * @description 添加用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:18
     */
    @Override
    public Integer insertUserInfo(UserEntity user) {
        return userMapper.insertUserInfo(user);
    }

    /**
     * @param pMap
     * @description 更新用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:18
     */
    @Override
    public Integer updateUserInfo(Map<String, Object> pMap) {
        return userMapper.updateUserInfo(pMap);
    }

    /**
     * @param pMap
     * @description 删除用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:19
     */
    @Override
    public Integer deleteUserInfo(Map<String, Object> pMap) {
        return userMapper.deleteUserInfo(pMap);
    }
}
