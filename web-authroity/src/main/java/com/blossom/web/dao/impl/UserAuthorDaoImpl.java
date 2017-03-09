package com.blossom.web.dao.impl;

import com.blossom.web.dao.IUserAuthorDao;
import com.blossom.web.mapper.UserAuthorMapper;
import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.UserAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/9 10:09
 */
@Repository("userAuthorDao")
public class UserAuthorDaoImpl implements IUserAuthorDao{

    @Autowired
    private UserAuthorMapper userAuthorMapper;

    /**
     * @param userAuthor
     * @description 添加用户权限
     * @author Blossom
     * @DateTime 2017/3/9 10:07
     */
    @Override
    public Integer saveUserAuthor(UserAuthorEntity userAuthor) {
        return userAuthorMapper.insertUserAuthorInfo(userAuthor);
    }

    /**
     * @param pMap
     * @description 删除用户权限
     * @author Blossom
     * @DateTime 2017/3/9 10:08
     */
    @Override
    public Integer removeUserAuthor(Map<String, Object> pMap) {
        return userAuthorMapper.deleteUserAuthorInfo(pMap);
    }

    /**
     * @param pMap
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:34
     */
    @Override
    public List<AuthorEntity> queryAuthorInfoByUserAccount(Map<String, Object> pMap) {
        return userAuthorMapper.queryAuthorInfoByUserAccount(pMap);
    }
}
