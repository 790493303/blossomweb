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
     * @description 删除角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:46
     */
    @Override
    public Integer removeAuthorInfo(Map<String, Object> pMap) {
        return authorMapper.deleteAuthorInfo(pMap);
    }

    /**
     * @param pMap
     * @description 更新角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:47
     */
    @Override
    public Integer updateAuthorInfo(Map<String, Object> pMap) {
        return authorMapper.updateAuthorInfo(pMap);
    }

    /**
     * @param author
     * @description 添加角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:48
     */
    @Override
    public Integer saveAuthorInfo(AuthorEntity author) {
        return authorMapper.insertAuthorInfo(author);
    }
}
