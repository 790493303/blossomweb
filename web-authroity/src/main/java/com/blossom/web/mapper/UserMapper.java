package com.blossom.web.mapper;

import com.blossom.web.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户Mapper
 * @time 2017/3/6 23:12
 */
@Mapper
public interface UserMapper {

    /**
     * @description 获取用户信息
     * @author Blossom
     * @DateTime 2017/3/8 9:47
     *
     */
    List<UserEntity> queryUserInfo(Map<String,Object> pMap);

    /**
     * @description 添加用户
     * @author Blossom
     * @DateTime 2017/3/8 9:49
     */
    Integer insertUserInfo(UserEntity user);

    /**
     * @description 删除用户
     * @author Blossom
     * @DateTime 2017/3/8 9:50
     */
    Integer deleteUserInfo(Map<String,Object> pMap);

    /**
     * @description 修改用户信息
     * @author Blossom
     * @DateTime 2017/3/8 9:51
     */
    Integer updateUserInfo(Map<String,Object> pMap);

}
