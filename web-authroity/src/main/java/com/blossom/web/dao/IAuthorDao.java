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
     * @description 删除角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:46
     * @param
     */
    Integer removeAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 更新角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:47
     * @param
     */
    Integer updateAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 添加角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:48
     * @param
     */
    Integer saveAuthorInfo(AuthorEntity author);

}
