package com.blossom.web.dao.impl;

import com.blossom.web.dao.IRoleAuthorDao;
import com.blossom.web.mapper.RoleAuthorMapper;
import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.RoleAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/9 10:12
 */
@Repository("roleAuthorDao")
public class RoleAuthorDaoImpl implements IRoleAuthorDao{

    @Autowired
    private RoleAuthorMapper roleAuthorMapper;

    /**
     * @param roleAuthor
     * @description 添加角色权限
     * @author Blossom
     * @DateTime 2017/3/9 10:11
     */
    @Override
    public Integer saveRoleAuthor(RoleAuthorEntity roleAuthor) {
        return roleAuthorMapper.insertRoleAuthorInfo(roleAuthor);
    }

    /**
     * @param pMap
     * @description 删除角色权限
     * @author Blossom
     * @DateTime 2017/3/9 10:11
     */
    @Override
    public Integer removeRoleAuthor(Map<String, Object> pMap) {
        return roleAuthorMapper.deleteRoleAuthorInfo(pMap);
    }

    /**
     * @param pMap
     * @description 根据角色获取权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:35
     */
    @Override
    public List<AuthorEntity> queryAuthorInfoByRoleId(Map<String, Object> pMap) {
        return roleAuthorMapper.queryAuthorInfoByRoleId(pMap);
    }
}
