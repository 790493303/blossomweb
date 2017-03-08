package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 角色service接口
 * @time 2017/3/6 23:22
 */
public interface IRoleService {

    /**
     * @description 根据用户账号获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:55
     * @param
     */
    JSONObject queryRoleInfoByUserAccount(JSONObject pJson);

}
