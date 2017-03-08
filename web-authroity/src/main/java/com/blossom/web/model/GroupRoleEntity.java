package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 组角色
 * @time 2017/3/6 22:53
 */
public class GroupRoleEntity implements Serializable{

    private static final long serialVersionUID = -179605806531042209L;
    //组角色编号
    private Integer groupRoleId;
    //组ID
    private Integer groupId;
    //角色ID
    private Integer roleId;

    public Integer getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(Integer groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
