package com.blossom.web.dao;

import com.blossom.web.model.AuthorEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限Dao接口
 * @time 2017/3/6 23:18
 */
public interface IAuthorDao {

    /**
     * @description 获取全部权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:32
     * @param
     */
    List<AuthorEntity> queryAllAuthorInfo();

    /**
     * @description 按条件获取权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:33
     * @param
     */
    List<AuthorEntity> queryAllAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:34
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByUserAccount(Map<String,Object> pMap);

    /**
     * @description 根据角色获取权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:35
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByRoleId(Map<String,Object> pMap);

}
