package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 角色权限
 * @time 2017/3/6 22:59
 */
public class RoleAuthorEntity implements Serializable{

    private static final long serialVersionUID = 6200912850406887545L;
    //角色权限编号
    private Integer roleAuthortyId;
    //权限编号
    private Integer authortyId;
    //角色编号
    private Integer roleId;
    //权限类型
    private Integer authortyType;

    public Integer getRoleAuthortyId() {
        return roleAuthortyId;
    }

    public void setRoleAuthortyId(Integer roleAuthortyId) {
        this.roleAuthortyId = roleAuthortyId;
    }

    public Integer getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(Integer authortyId) {
        this.authortyId = authortyId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthortyType() {
        return authortyType;
    }

    public void setAuthortyType(Integer authortyType) {
        this.authortyType = authortyType;
    }
}
