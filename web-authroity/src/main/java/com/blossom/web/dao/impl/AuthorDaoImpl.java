package com.blossom.web.dao.impl;

import com.blossom.web.dao.IAuthorDao;
import com.blossom.web.mapper.AuthorMapper;
import com.blossom.web.model.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限Dao接口实现
 * @time 2017/3/6 23:20
 */
@Repository("authorDao")
public class AuthorDaoImpl implements IAuthorDao{

    @Autowired
    private AuthorMapper authorMapper;

    /**
     * @description 获取全部权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:32
     */
    @Override
    public List<AuthorEntity> queryAllAuthorInfo() {
        Map<String,Object> map = new HashMap<>();

        return authorMapper.queryAllAuthorInfo(map);
    }

    /**
     * @param pMap
     * @description 按条件获取权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:33
     */
    @Override
    public List<AuthorEntity> queryAllAuthorInfo(Map<String, Object> pMap) {
        return authorMapper.queryAllAuthorInfo(pMap);
    }

    /**
     * @param pMap
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:34
     */
    @Override
    public List<AuthorEntity> queryAuthorInfoByUserAccount(Map<String, Object> pMap) {
        return authorMapper.queryAuthorInfoByUserAccount(pMap);
    }

    /**
     * @param pMap
     * @description 根据角色获取权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:35
     */
    @Override
    public List<AuthorEntity> queryAuthorInfoByRoleId(Map<String, Object> pMap) {
        return authorMapper.queryAuthorInfoByRoleId(pMap);
    }
}
