package com.nantian.user.api.domain;

public class MenuInfo {
    private String idMenu;

    private String namMenu;

    private String codParntMenu;

    private Integer codMenuState;

    private Integer vluMenuSeq;

    private String codMenuType;

    private String txtMenuUrl;

    private String txtMenuDscr;

    private String vluMenuIcon;

    private String indDlgt;

    private String code;

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu == null ? null : idMenu.trim();
    }

    public String getNamMenu() {
        return namMenu;
    }

    public void setNamMenu(String namMenu) {
        this.namMenu = namMenu == null ? null : namMenu.trim();
    }

    public String getCodParntMenu() {
        return codParntMenu;
    }

    public void setCodParntMenu(String codParntMenu) {
        this.codParntMenu = codParntMenu == null ? null : codParntMenu.trim();
    }

    public Integer getCodMenuState() {
        return codMenuState;
    }

    public void setCodMenuState(Integer codMenuState) {
        this.codMenuState = codMenuState;
    }

    public Integer getVluMenuSeq() {
        return vluMenuSeq;
    }

    public void setVluMenuSeq(Integer vluMenuSeq) {
        this.vluMenuSeq = vluMenuSeq;
    }

    public String getCodMenuType() {
        return codMenuType;
    }

    public void setCodMenuType(String codMenuType) {
        this.codMenuType = codMenuType == null ? null : codMenuType.trim();
    }

    public String getTxtMenuUrl() {
        return txtMenuUrl;
    }

    public void setTxtMenuUrl(String txtMenuUrl) {
        this.txtMenuUrl = txtMenuUrl == null ? null : txtMenuUrl.trim();
    }

    public String getTxtMenuDscr() {
        return txtMenuDscr;
    }

    public void setTxtMenuDscr(String txtMenuDscr) {
        this.txtMenuDscr = txtMenuDscr == null ? null : txtMenuDscr.trim();
    }

    public String getVluMenuIcon() {
        return vluMenuIcon;
    }

    public void setVluMenuIcon(String vluMenuIcon) {
        this.vluMenuIcon = vluMenuIcon == null ? null : vluMenuIcon.trim();
    }

    public String getIndDlgt() {
        return indDlgt;
    }

    public void setIndDlgt(String indDlgt) {
        this.indDlgt = indDlgt == null ? null : indDlgt.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}