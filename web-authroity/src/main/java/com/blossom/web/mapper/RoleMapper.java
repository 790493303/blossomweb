package com.blossom.web.mapper;

import com.blossom.web.model.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Blossom
 * @Description 角色Mapper
 * @time 2017/3/6 23:13
 */
@Mapper
public interface RoleMapper {

    /**
     * @description 获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:42
     * @param
     */
    List<RoleEntity> queryAllRoleInfo(Map<String,Object> pMap);

    /**
     * @description 根据账号获取角色信息
     * @author Blossom
     * @DateTime 2017/3/8 14:43
     * @param
     */
    List<RoleEntity> queryRoleInfoByUserAccount(Map<String,Object> pMap);

}
