package com.nantian.user.manager.domain;

import com.nantian.user.api.domain.MenuInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author WangJinYi 2021/3/17
 */
public class MenuInfoQO extends MenuInfo {

    @ApiModelProperty(value = "每页条数", example = "10")
    private Integer limit;
    @ApiModelProperty(value = "页码", example = "1")
    private Integer page;

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
