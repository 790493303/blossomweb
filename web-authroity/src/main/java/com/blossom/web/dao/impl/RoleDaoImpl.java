package com.blossom.web.dao.impl;

import com.blossom.web.dao.IRoleDao;
import com.blossom.web.mapper.RoleMapper;
import com.blossom.web.model.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限Dao接口实现
 * @time 2017/3/6 23:19
 */
@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao{

    @Autowired
    private RoleMapper roleMapper;


    /**
     * @description 获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:38
     */
    @Override
    public List<RoleEntity> queryAllRoleInfo() {
        Map<String,Object> map = new HashMap<>();

        return roleMapper.queryAllRoleInfo(map);
    }

    /**
     * @param pMap
     * @description 根据用户账号获取角色
     * @author Blossom
     * @DateTime 2017/3/8 14:40
     */
    @Override
    public List<RoleEntity> queryRoleInfoByUserAccount(Map<String, Object> pMap) {
        return roleMapper.queryRoleInfoByUserAccount(pMap);
    }
}
