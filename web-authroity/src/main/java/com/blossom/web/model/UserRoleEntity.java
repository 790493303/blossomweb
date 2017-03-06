package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 用户角色
 * @time 2017/3/6 23:08
 */
public class UserRoleEntity implements Serializable{

    //用户角色编号
    private Integer userRoleId;
    //用户编号
    private Integer userId;
    //角色编号
    private Integer roleId;


    public Integer getUserRoleId() {
        return userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getRoleId() {
        return roleId;
    }
}
