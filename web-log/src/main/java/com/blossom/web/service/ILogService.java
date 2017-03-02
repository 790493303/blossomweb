package com.blossom.web.service;

import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description log service 接口
 * @time 2017/3/2 11:19
 */
public interface ILogService {

    /**
     * @description 添加log服务
     * @author Blossom
     * @DateTime 2017/3/2 11:20
     *
     **/
    JSONObject insertLogInfo(JSONObject pJson);
}
