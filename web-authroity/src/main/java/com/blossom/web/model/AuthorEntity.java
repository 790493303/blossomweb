package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 权限实体
 * @time 2017/3/6 22:42
 */
public class AuthorEntity implements Serializable{

    //权限编号
    private Integer authortyId;
    //父权限编号
    private Integer parentAuthortyId;
    //权限名称
    private String authortyName;
    //权限说明
    private String authortyDescription;
    //权限URL
    private String authortyUrl;

    public Integer getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(Integer authortyId) {
        this.authortyId = authortyId;
    }

    public Integer getParentAuthortyId() {
        return parentAuthortyId;
    }

    public void setParentAuthortyId(Integer parentAuthortyId) {
        this.parentAuthortyId = parentAuthortyId;
    }

    public String getAuthortyName() {
        return authortyName;
    }

    public void setAuthortyName(String authortyName) {
        this.authortyName = authortyName;
    }

    public String getAuthortyDescription() {
        return authortyDescription;
    }

    public void setAuthortyDescription(String authortyDescription) {
        this.authortyDescription = authortyDescription;
    }

    public String getAuthortyUrl() {
        return authortyUrl;
    }

    public void setAuthortyUrl(String authortyUrl) {
        this.authortyUrl = authortyUrl;
    }

}
