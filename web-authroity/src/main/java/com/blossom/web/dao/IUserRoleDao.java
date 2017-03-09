package com.blossom.web.dao;

import com.blossom.web.model.RoleEntity;
import com.blossom.web.model.UserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户角色Dao接口
 * @time 2017/3/9 10:00
 */
public interface IUserRoleDao {

    /**
     * @description 添加用户角色
     * @author Blossom
     * @DateTime 2017/3/9 10:00
     * @param
     */
    Integer saveUserRole(UserRoleEntity userRole);

    /**
     * @description 删除用户角色
     * @author Blossom
     * @DateTime 2017/3/9 10:01
     * @param
     */
    Integer removeUserRole(Map<String,Object> pMap);

    /**
     * @description 根据用户账号获取角色
     * @author Blossom
     * @DateTime 2017/3/8 14:40
     * @param pMap
     */
    List<RoleEntity> queryRoleInfoByUserAccount(Map<String,Object> pMap);

}
