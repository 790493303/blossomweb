package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 用户组
 * @time 2017/3/6 23:06
 */
public class UserGroupEntity implements Serializable{

    //用户组编号
    private Integer userGroupId;
    //用户编号
    private Integer userId;
    //组编号
    private Integer groupId;

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
