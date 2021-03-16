package com.nantian.user.manager.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author WangJinYi 2021/3/16
 */
@ApiModel("角色查询类")
public class RoleInfoQO {

    @ApiModelProperty("角色名称")
    private String name;
    @ApiModelProperty("角色状态")
    private String state;
    @ApiModelProperty("系统编号")
    private String appId;
    @ApiModelProperty("每页条数")
    private Integer limit;
    @ApiModelProperty("页码")
    private Integer page;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
