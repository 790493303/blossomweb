package com.blossom.web.mapper;

import com.blossom.web.model.LogHandleModel;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:22:41
 */
@Mapper
public interface LogHandleMapper {
	
	/**
	 * @Description: 添加操作日志
	 * @author Blossom
	 * @time 2017年3月2日 下午3:24:00 
	 * @return_type Integer
	 *
	 */
	Integer insertLogHandleInfo(LogHandleModel log);
	
}
