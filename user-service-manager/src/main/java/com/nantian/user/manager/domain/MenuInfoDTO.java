package com.nantian.user.manager.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author WangJinYi 2021/3/17
 */
public class MenuInfoDTO {

    @ApiModelProperty("主键,编辑使用")
    private String id;
    @ApiModelProperty("菜单编号")
    private String code;
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("上级菜单编号")
    private String pCode;
    @ApiModelProperty("1:启用，0:停用")
    private Integer state;
    @ApiModelProperty("排序")
    private Integer seq;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("路由")
    private String menuUrl;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("路径")
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
