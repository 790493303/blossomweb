package com.blossom.web.dao.impl;

import com.blossom.web.dao.ILogHandleDao;
import com.blossom.web.mapper.LogHandleMapper;
import com.blossom.web.model.LogHandleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:50:59
 */
@Repository
public class LogHandleDaoImpl implements ILogHandleDao {

	@Autowired
	private LogHandleMapper logHandleMapper;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @throws Exception 
	 * @throws Exception
	 * @time 2017年3月2日 下午3:50:59
	 * @see com.blossom.web.dao.ILogHandleDao#insertLogHandleInfo(com.blossom.web.model.LogHandleModel)
	 */
	public Integer insertLogHandleInfo(LogHandleModel logHandle) throws Exception {
		if (logHandle == null) {
			throw new Exception("参数不全!");
		}
		return logHandleMapper.insertLogHandleInfo(logHandle);
	}

}
