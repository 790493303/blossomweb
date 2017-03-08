package com.blossom.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Blossom
 * @Description 用户实体
 * @time 2017/3/6 23:01
 */
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -6236158510987657132L;
    //用户编号
    private Integer userId;
    //组织编号
    private Integer organizationId;
    //登录账号
    private String loginAccount;
    //登录密码
    private String loginPassword;
    //用户名
    private String userName;
    //手机号
    private String telephone;
    //邮箱
    private String email;
    //注册时间
    private Date createTime;
    //登录时间
    private Date loginTime;
    //最后一次登录时间
    private Date lastLoginTime;
    //登录次数
    private Integer loginCount;

    public Integer getUserId() {
        return userId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
}
