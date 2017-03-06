package com.blossom.web.dao.impl;

import com.blossom.web.dao.IAuthorDao;
import com.blossom.web.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Blossom
 * @Description 权限Dao接口实现
 * @time 2017/3/6 23:20
 */
@Repository("authorDao")
public class AuthorDaoImpl implements IAuthorDao{

    @Autowired
    private AuthorMapper authorMapper;

}
