package com.blossom.web.mapper;

import com.blossom.web.model.AuthorEntity;
import com.blossom.web.model.RoleAuthorEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色权限
 * @time 2017/3/9 9:37
 */
@Mapper
public interface RoleAuthorMapper {

    /**
     * @description 添加角色权限
     * @author Blossom
     * @DateTime 2017/3/9 9:38
     * @param
     */
    Integer insertRoleAuthorInfo(RoleAuthorEntity roleAuthor);

    /**
     * @description 删除角色权限
     * @author Blossom
     * @DateTime 2017/3/9 9:39
     * @param
     */
    Integer deleteRoleAuthorInfo(Map<String,Object> pMap);

    /**
     * @description 根据角色编号获取权限
     * @author Blossom
     * @DateTime 2017/3/8 15:09
     * @param
     */
    List<AuthorEntity> queryAuthorInfoByRoleId(Map<String,Object> pMap);

}
