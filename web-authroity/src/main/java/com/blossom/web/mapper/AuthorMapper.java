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
     * @description 添加角色
     * @author Blossom
     * @DateTime 2017/3/8 22:21
     * @param
     */
    Integer insertAuthorInfo(AuthorEntity author);

    /**
     * @description 删除角色
     * @author Blossom
     * @DateTime 2017/3/8 22:22
     * @param
     */
    Integer deleteAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 修改角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:23
     * @param
     */
    Integer updateAuthorInfo(Map<String,Object> pMap);

}
