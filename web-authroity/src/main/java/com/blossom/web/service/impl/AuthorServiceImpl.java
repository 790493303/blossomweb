package com.blossom.web.service.impl;

import com.blossom.web.dao.IAuthorDao;
import com.blossom.web.service.IAuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Blossom
 * @Description 权限service接口实现
 * @time 2017/3/6 23:25
 */
@Service("authorService")
public class AuthorServiceImpl implements IAuthorService{

    @Resource(name = "authorDao")
    private IAuthorDao authorDao;
}
