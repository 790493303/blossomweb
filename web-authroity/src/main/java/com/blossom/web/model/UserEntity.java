package com.blossom.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Blossom
 * @Description 用户实体
 * @time 2017/3/6 23:01
 */
public class UserEntity implements Serializable{

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





}
