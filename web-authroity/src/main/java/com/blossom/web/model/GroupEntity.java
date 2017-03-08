package com.blossom.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Blossom
 * @Description 组实体
 * @time 2017/3/6 22:42
 */
public class GroupEntity implements Serializable{

    private static final long serialVersionUID = -3047316469890337897L;
    //组编号
    private Integer groupId;
    //组名称
    private String groupName;
    //父组编号
    private Integer parentGroupId;
    //创建时间
    private Date createTime;
    //组说明
    private String groupDescription;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Integer parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
}
