package com.blossom.web.dao.impl;

import com.blossom.web.dao.ILogSystemDao;
import com.blossom.web.mapper.LogSystemMapper;
import com.blossom.web.model.LogSystemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:52:35
 */
@Repository
public class LogSysetmDaoImpl implements ILogSystemDao {

	@Autowired
	private LogSystemMapper logSystemMapper;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月2日 下午3:52:35
	 * @see com.blossom.log.dao.ILogSystemDao#queryLogHandle(Map)
	 */
	public List<LogSystemModel> queryLogHandle(Map<String, Object> pMap) {
		
		return logSystemMapper.queryLogSystem(pMap);
	}

}
