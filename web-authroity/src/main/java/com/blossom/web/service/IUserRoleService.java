package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 用户权限service接口
 * @time 2017/3/9 11:31
 */
public interface IUserRoleService {

    /**
     * @description 添加用户角色
     * @author Blossom
     * @DateTime 2017/3/9 11:32
     * @param
     */
    JSONObject saveUserRole(JSONObject pJson);

    /**
     * @description 删除用户角色
     * @author Blossom
     * @DateTime 2017/3/9 11:32
     * @param
     */
    JSONObject removeUserRole(JSONObject pJson);

}
