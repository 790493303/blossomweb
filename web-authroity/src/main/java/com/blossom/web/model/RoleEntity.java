package com.blossom.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Blossom
 * @Description 角色编号
 * @time 2017/3/6 23:09
 */
public class RoleEntity implements Serializable{

    private static final long serialVersionUID = 8325178831720827238L;
    //角色编号
    private Integer roleId;
    //父角色编号
    private Integer parentRoleId;
    //角色名称
    private String roleName;
    //创建时间
    private Date createTime;
    //角色说明
    private  String roleDescription;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getParentRoleId() {
        return parentRoleId;
    }

    public void setParentRoleId(Integer parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public RoleEntity(Integer roleId, Integer parentRoleId, String roleName, Date createTime, String roleDescription) {
        this.roleId = roleId;
        this.parentRoleId = parentRoleId;
        this.roleName = roleName;
        this.createTime = createTime;
        this.roleDescription = roleDescription;
    }
}
