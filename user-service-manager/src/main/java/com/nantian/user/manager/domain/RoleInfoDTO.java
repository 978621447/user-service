package com.nantian.user.manager.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author WangJinYi 2021/3/16
 */
public class RoleInfoDTO {

    @ApiModelProperty("角色名称")
    private String name;
    @ApiModelProperty("1:启用，0:停用")
    private String state;
    @ApiModelProperty("上级角色")
    private String pid;
    @ApiModelProperty("系统编码")
    private String appId;
    @ApiModelProperty("机构编码")
    private String orgId;
    @ApiModelProperty(value = "排序", example = "1")
    private Integer seq;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("资源类型")
    private String resourceType;
    @ApiModelProperty("资源类型编码")
    private String resourceCode;
    @ApiModelProperty("描述")
    private String description;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
