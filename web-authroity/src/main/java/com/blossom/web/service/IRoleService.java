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

    /**
     * @description 获取全部角色
     * @author Blossom
     * @DateTime 2017/3/9 10:19
     * @param
     */
    JSONObject queryAllRoleInfo(JSONObject pJson);

    /**
     * @description 添加角色信息
     * @author Blossom
     * @DateTime 2017/3/9 10:20
     * @param
     */
    JSONObject saveRoleInfo(JSONObject pJson);

    /**
     * @description 修改角色信息
     * @author Blossom
     * @DateTime 2017/3/9 10:21
     * @param
     */
    JSONObject updateRoleInfo(JSONObject pJson);

    /**
     * @description 删除角色
     * @author Blossom
     * @DateTime 2017/3/9 10:21
     * @param
     */
    JSONObject removeRoleInfo(JSONObject pJson);

}
