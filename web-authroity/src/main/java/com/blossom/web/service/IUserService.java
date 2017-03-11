package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 用户service接口
 * @time 2017/3/6 23:21
 */
public interface IUserService {

    /**
     * @description 获取所有用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:31
     */
    JSONObject queryAllUserInfo(JSONObject pJson);

    /**
     * @description 获取指定用户信息
     * @author Blossom
     * @DateTime 2017/3/8 10:32
     */
    JSONObject queryUserInfo(JSONObject pJson);

    /**
     * @description 添加用户信息
     * @author Blossom
     * @DateTime 2017/3/8 13:42
     */
    JSONObject saveUserInfo(JSONObject pJson);

    /**
     * @description 删除用户信息
     * @author Blossom
     * @DateTime 2017/3/8 13:43
     */
    JSONObject removeUserInfo(JSONObject pJson);

    /**
     * @description 修改用户信息
     * @author Blossom
     * @DateTime 2017/3/8 13:43
     */
    JSONObject updateUserInfo(JSONObject pJson);

    /**
     * @description 获取用户角色
     * @author Blossom
     * @DateTime 2017/3/8 16:06
     * @param
     */
    JSONObject queryUserRole(JSONObject pJson);

    /**
     * @description 获取用户权限
     * @author Blossom
     * @DateTime 2017/3/8 16:07
     * @param
     */
    JSONObject queryUserAuthor(JSONObject pJson);

}
