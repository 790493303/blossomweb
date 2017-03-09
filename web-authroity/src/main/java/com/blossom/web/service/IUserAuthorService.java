package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 用户权限sevice接口
 * @time 2017/3/9 11:44
 */
public interface IUserAuthorService {

    /**
     * @description 添加用户权限
     * @author Blossom
     * @DateTime 2017/3/9 11:44
     * @param
     */
    JSONObject saveUserAuthor(JSONObject pJson);

    /**
     * @description 删除用户权限
     * @author Blossom
     * @DateTime 2017/3/9 11:45
     * @param
     */
    JSONObject removeUserAuthor(JSONObject pJson);

}
