package com.blossom.web.dao;

import com.blossom.web.model.RoleEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色Dao接口
 * @time 2017/3/6 23:17
 */
public interface IRoleDao {

    /**
     * @description 获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:38
     * @param
     */
    List<RoleEntity> queryAllRoleInfo();

    /**
     * @description 根据用户账号获取角色
     * @author Blossom
     * @DateTime 2017/3/8 14:40
     * @param pMap
     */
    List<RoleEntity> queryRoleInfoByUserAccount(Map<String,Object> pMap);

}
