package com.nantian.user.manager.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author WangJinYi 2021/3/17
 */
@ApiModel("用户查询类")
public class UserInfoQO {

    @ApiModelProperty("所属机构")
    private String orgId;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("页码")
    private Integer page;
    @ApiModelProperty("每页条数")
    private Integer limit;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
