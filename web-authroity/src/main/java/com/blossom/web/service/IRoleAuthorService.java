package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 角色权限sevice接口
 * @time 2017/3/9 11:15
 */
public interface IRoleAuthorService {

    /**
     * @description 添加角色权限
     * @author Blossom
     * @DateTime 2017/3/9 11:15
     * @param
     */
    JSONObject saveRoleAuthor(JSONObject pJson);

    /**
     * @description 删除角色权限
     * @author Blossom
     * @DateTime 2017/3/9 11:16
     * @param
     */
    JSONObject removeRoleAuthor(JSONObject pJson);
}
