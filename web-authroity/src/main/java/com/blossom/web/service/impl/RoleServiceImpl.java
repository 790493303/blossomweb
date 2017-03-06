package com.blossom.web.service.impl;

import com.blossom.web.dao.IRoleDao;
import com.blossom.web.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Blossom
 * @Description 角色service接口实现
 * @time 2017/3/6 23:24
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Resource(name = "roleDao")
    private IRoleDao roleDao;

}
