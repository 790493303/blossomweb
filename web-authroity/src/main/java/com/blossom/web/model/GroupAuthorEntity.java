package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 组权限
 * @time 2017/3/6 22:50
 */
public class GroupAuthorEntity implements Serializable{

    //组权限编号
    private Integer groupAuthortyId;
    //组ID
    private Integer groupId;
    //权限ID
    private Integer authortyId;
    //权限类型
    private Integer authortyType;

    public Integer getGroupAuthortyId() {
        return groupAuthortyId;
    }

    public void setGroupAuthortyId(Integer groupAuthortyId) {
        this.groupAuthortyId = groupAuthortyId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(Integer authortyId) {
        this.authortyId = authortyId;
    }

    public Integer getAuthortyType() {
        return authortyType;
    }

    public void setAuthortyType(Integer authortyType) {
        this.authortyType = authortyType;
    }

    public GroupAuthorEntity(Integer groupAuthortyId, Integer groupId, Integer authortyId, Integer authortyType) {
        this.groupAuthortyId = groupAuthortyId;
        this.groupId = groupId;
        this.authortyId = authortyId;
        this.authortyType = authortyType;
    }
}
