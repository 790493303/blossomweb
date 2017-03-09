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
     * @description 添加角色
     * @author Blossom
     * @DateTime 2017/3/8 22:39
     * @param
     */
    Integer insertRoleInfo(RoleEntity role);

    /**
     * @description 删除角色
     * @author Blossom
     * @DateTime 2017/3/8 22:40
     * @param
     */
    Integer deleteRoleInfo(Map<String,Object> pMap);

    /**
     * @description 更新角色信息
     * @author Blossom
     * @DateTime 2017/3/8 22:40
     * @param
     */
    Integer updateRoleInfo(Map<String,Object> pMap);

}
