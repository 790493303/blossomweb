package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 权限service接口
 * @time 2017/3/6 23:22
 */
public interface IAuthorService {

    /**
     * @description 获取全部的权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:37
     * @param pJson
     */
    JSONObject queryAllAuthorInfo(JSONObject pJson);

    /**
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:38
     * @param
     */
    JSONObject queryAuthorInfoByUserAccount(JSONObject pJson);

    /**
     * @description 根据角色获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:39
     * @param
     */
    JSONObject queryAuthorInfoByRoleId(JSONObject pJson);

}
