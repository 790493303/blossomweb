package com.blossom.web.dao;

import com.blossom.web.model.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户Dao接口
 * @time 2017/3/6 23:17
 */
public interface IUserDao {

    /**
     * @description 获取全部的用户
     * @author Blossom
     * @DateTime 2017/3/8 10:15
     */
    List<UserEntity> queryAllUserInfo();

    /**
     * @description 获取指定的用户
     * @author Blossom
     * @DateTime 2017/3/8 10:15
     */
    UserEntity queryOneUserInfo(Map<String,Object> pMap);

    /**
     * @description 添加用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:18
     */
    Integer insertUserInfo(UserEntity user);

    /**
     * @description 更新用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:18
     */
    Integer updateUserInfo(Map<String,Object> pMap);

    /**
     * @description 删除用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:19
     */
    Integer deleteUserInfo(Map<String,Object> pMap);


}
