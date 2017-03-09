package com.blossom.web.mapper;

import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.UserAuthorEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 用户权限
 * @time 2017/3/9 9:35
 */
@Mapper
public interface UserAuthorMapper {

    /**
     * @description 添加用户权限
     * @author Blossom
     * @DateTime 2017/3/9 9:35
     * @param
     */
    Integer insertUserAuthorInfo(UserAuthorEntity userAuthor);

    /**
     * @description 删除用户权限
     * @author Blossom
     * @DateTime 2017/3/9 9:36
     * @param
     */
    Integer deleteUserAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:08
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByUserAccount(Map<String,Object> pMap);

}
