package com.blossom.web.dao;

import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.RoleAuthorEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色权限
 * @time 2017/3/9 10:10
 */
public interface IRoleAuthorDao {

    /**
     * @description 添加角色权限
     * @author Blossom
     * @DateTime 2017/3/9 10:11
     * @param
     */
    Integer saveRoleAuthor(RoleAuthorEntity roleAuthor);

    /**
     * @description 删除角色权限
     * @author Blossom
     * @DateTime 2017/3/9 10:11
     * @param
     */
    Integer removeRoleAuthor(Map<String,Object> pMap);

    /**
     * @description 根据角色获取权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:35
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByRoleId(Map<String,Object> pMap);

}
