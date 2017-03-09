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
     * @description 按条件获取角色信息
     * @author Blossom
     * @DateTime 2017/3/9 10:45
     * @param
     */
    List<RoleEntity> queryRoleInfo(Map<String,Object> pMap);

    /**
     * @description 添加角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:50
     * @param
     */
    Integer saveRoleInfo(RoleEntity role);

    /**
     * @description 删除角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:50
     * @param
     */
    Integer removeRoleInfo(Map<String,Object> pMap);

    /**
     * @description 更新角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:51
     * @param
     */
    Integer updateRoleInfo(Map<String,Object> pMap);


}
