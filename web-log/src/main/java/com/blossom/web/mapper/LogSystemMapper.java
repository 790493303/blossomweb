package com.blossom.web.mapper;

import com.blossom.web.model.LogSystemModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:34:18
 */
@Mapper
public interface LogSystemMapper {
	
	/**
	 * @Description: 获取系统日志
	 * @author Blossom
	 * @time 2017年3月2日 下午3:35:19 
	 * @return_type List<LogSystemModel>
	 *
	 */
	List<LogSystemModel> queryLogSystem(Map<String, Object> pMap);

}
