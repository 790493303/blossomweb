package com.blossom.web.dao.impl;

import com.blossom.web.dao.IUserRoleDao;
import com.blossom.web.mapper.UserRoleMapper;
import com.blossom.web.model.RoleEntity;
import com.blossom.web.model.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/9 10:04
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl  implements IUserRoleDao{

    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * @param userRole
     * @description 添加用户角色
     * @author Blossom
     * @DateTime 2017/3/9 10:00
     */
    @Override
    public Integer saveUserRole(UserRoleEntity userRole) {
        return userRoleMapper.insertUserRole(userRole);
    }

    /**
     * @param pMap
     * @description 删除用户角色
     * @author Blossom
     * @DateTime 2017/3/9 10:01
     */
    @Override
    public Integer removeUserRole(Map<String, Object> pMap) {
        return userRoleMapper.deleteUserRole(pMap);
    }

    /**
     * @param pMap
     * @description 根据用户账号获取角色
     * @author Blossom
     * @DateTime 2017/3/8 14:40
     */
    @Override
    public List<RoleEntity> queryRoleInfoByUserAccount(Map<String, Object> pMap) {
        return userRoleMapper.queryRoleInfoByUserAccount(pMap);
    }
}
