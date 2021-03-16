package com.nantian.user.api.domain;

public class RoleInfo {
    private String idRole;

    private String namRole;

    private String codRoleState;

    private String idParntRole;

    private Integer vluRoleSeq;

    private String codRoleType;

    private String idOrg;

    private String idCrtor;

    private String namCrtor;

    private String timeCrt;

    private String txtRoleDscr;

    private String indResTyp;

    private String idRes;

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole == null ? null : idRole.trim();
    }

    public String getNamRole() {
        return namRole;
    }

    public void setNamRole(String namRole) {
        this.namRole = namRole == null ? null : namRole.trim();
    }

    public String getCodRoleState() {
        return codRoleState;
    }

    public void setCodRoleState(String codRoleState) {
        this.codRoleState = codRoleState == null ? null : codRoleState.trim();
    }

    public String getIdParntRole() {
        return idParntRole;
    }

    public void setIdParntRole(String idParntRole) {
        this.idParntRole = idParntRole == null ? null : idParntRole.trim();
    }

    public Integer getVluRoleSeq() {
        return vluRoleSeq;
    }

    public void setVluRoleSeq(Integer vluRoleSeq) {
        this.vluRoleSeq = vluRoleSeq;
    }

    public String getCodRoleType() {
        return codRoleType;
    }

    public void setCodRoleType(String codRoleType) {
        this.codRoleType = codRoleType == null ? null : codRoleType.trim();
    }

    public String getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(String idOrg) {
        this.idOrg = idOrg == null ? null : idOrg.trim();
    }

    public String getIdCrtor() {
        return idCrtor;
    }

    public void setIdCrtor(String idCrtor) {
        this.idCrtor = idCrtor == null ? null : idCrtor.trim();
    }

    public String getNamCrtor() {
        return namCrtor;
    }

    public void setNamCrtor(String namCrtor) {
        this.namCrtor = namCrtor == null ? null : namCrtor.trim();
    }

    public String getTimeCrt() {
        return timeCrt;
    }

    public void setTimeCrt(String timeCrt) {
        this.timeCrt = timeCrt == null ? null : timeCrt.trim();
    }

    public String getTxtRoleDscr() {
        return txtRoleDscr;
    }

    public void setTxtRoleDscr(String txtRoleDscr) {
        this.txtRoleDscr = txtRoleDscr == null ? null : txtRoleDscr.trim();
    }

    public String getIndResTyp() {
        return indResTyp;
    }

    public void setIndResTyp(String indResTyp) {
        this.indResTyp = indResTyp == null ? null : indResTyp.trim();
    }

    public String getIdRes() {
        return idRes;
    }

    public void setIdRes(String idRes) {
        this.idRes = idRes == null ? null : idRes.trim();
    }
}