package com.blossom.web.model;

import java.io.Serializable;

/**
 * @author Blossom
 * @Description 组织实体
 * @time 2017/3/6 22:55
 */
public class OriginizationEntity implements Serializable{

    //组织编号
    private Integer organizationId;
    //父组织编号
    private Integer parentOrganizationId;
    //组织名称
    private String organizationName;
    //组织说明
    private String organizationDescription;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getParentOrganizationId() {
        return parentOrganizationId;
    }

    public void setParentOrganizationId(Integer parentOrganizationId) {
        this.parentOrganizationId = parentOrganizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public OriginizationEntity(Integer organizationId, Integer parentOrganizationId, String organizationName, String organizationDescription) {
        this.organizationId = organizationId;
        this.parentOrganizationId = parentOrganizationId;
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
    }
}
