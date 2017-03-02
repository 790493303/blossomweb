package com.blossom.web.mapper;

import com.blossom.web.model.LogModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Blossom
 * @Description log 操作数据库
 * @time 2017/3/2 11:04
 */
@Mapper
public interface LogMapper {

    /**
     * @description 添加日志信息
     * @author Blossom
     * @DateTime 2017/3/2 11:06
     *
     **/
    Integer insertLogInfo(LogModel log);
}
