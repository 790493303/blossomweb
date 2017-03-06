package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 用户权限
 * @time 2017/3/6 23:05
 */
public class UserAuthorEntity implements Serializable{

    //用户权限编号
    private Integer userAuthortyId;
    //用户编号
    private Integer userId;
    //权限编号
    private Integer authortyId;
    //权限类型
    private String authortyType;

    public Integer getUserAuthortyId() {
        return userAuthortyId;
    }

    public void setUserAuthortyId(Integer userAuthortyId) {
        this.userAuthortyId = userAuthortyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(Integer authortyId) {
        this.authortyId = authortyId;
    }

    public String getAuthortyType() {
        return authortyType;
    }

    public void setAuthortyType(String authortyType) {
        this.authortyType = authortyType;
    }
}
