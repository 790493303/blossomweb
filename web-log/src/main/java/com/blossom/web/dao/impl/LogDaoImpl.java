package com.blossom.web.dao.impl;

import com.blossom.web.dao.ILogDao;
import com.blossom.web.mapper.LogMapper;
import com.blossom.web.model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Blossom
 * @Description log dao 操作接口实现
 * @time 2017/3/2 11:15
 */
@Repository
public class LogDaoImpl implements ILogDao{

    @Autowired
    private LogMapper logMapper;

    /**
     * @param log
     * @description 添加日志
     * @author Blossom
     * @DateTime 2017/3/2 11:16
     */
    @Override
    public Integer insertLogInfo(LogModel log) throws Exception {
        if (log == null){
            throw  new Exception("参数为空!");
        }

        return logMapper.insertLogInfo(log);
    }
}
