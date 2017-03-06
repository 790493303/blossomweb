package com.blossom.web.dao.impl;

import com.blossom.web.dao.IRoleDao;
import com.blossom.web.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Blossom
 * @Description 权限Dao接口实现
 * @time 2017/3/6 23:19
 */
@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao{

    @Autowired
    private RoleMapper roleMapper;


}
