package com.blossom.web.mapper;

import com.blossom.web.model.AuthorEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 权限Mapper
 * @time 2017/3/6 23:13
 */
@Mapper
public interface AuthorMapper {

    /**
     * @description 获取全部的权限信息
     * @author Blossom
     * @DateTime 2017/3/8 15:04
     * @param
     */
    List<AuthorEntity> queryAllAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 根据用户账号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:08
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByUserAccount(Map<String,Object> pMap);

    /**
     * @description 根据角色编号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:09
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByRoleId(Map<String,Object> pMap);

}
