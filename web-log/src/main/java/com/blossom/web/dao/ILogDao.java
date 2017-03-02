package com.blossom.web.dao;

import com.blossom.web.model.LogModel;

/**
 * @author Blossom
 * @Description log dao 操作接口
 * @time 2017/3/2 11:14
 */
public interface ILogDao {

    /**
     * @description 添加日志
     * @author Blossom
     * @DateTime 2017/3/2 11:16
     *
     **/
    Integer insertLogInfo(LogModel log) throws Exception;
}
