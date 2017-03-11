package com.blossom.web.dao;

import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.UserAuthorEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户权限Dao接口
 * @time 2017/3/9 10:06
 */
public interface IUserAuthorDao {

    /**
     * @description 添加用户权限
     * @author Blossom
     * @DateTime 2017/3/9 10:07
     * @param
     */
    Integer saveUserAuthor(UserAuthorEntity userAuthor);

    /**
     * @description 删除用户权限
     * @author Blossom
     * @DateTime 2017/3/9 10:08
     * @param
     */
    Integer removeUserAuthor(Map<String,Object> pMap);

    /**
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:34
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByUserAccount(Map<String,Object> pMap);

}
