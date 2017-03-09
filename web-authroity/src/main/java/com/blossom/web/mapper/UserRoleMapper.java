package com.blossom.web.mapper;

import com.blossom.web.model.RoleEntity;
import com.blossom.web.model.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户角色
 * @time 2017/3/8 23:18
 */
@Mapper
public interface UserRoleMapper {

    /**
     * @description 添加用户角色
     * @author Blossom
     * @DateTime 2017/3/9 9:33
     * @param
     */
    Integer insertUserRole(UserRoleEntity userRole);

    /**
     * @description 删除用户角色
     * @author Blossom
     * @DateTime 2017/3/9 9:33
     * @param
     */
    Integer deleteUserRole(Map<String,Object> pMap);

    /**
     * @description 根据账号获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:43
     * @param
     */
    List<RoleEntity> queryRoleInfoByUserAccount(Map<String,Object> pMap);

}
