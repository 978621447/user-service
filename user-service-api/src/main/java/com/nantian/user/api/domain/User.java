package com.nantian.user.api.domain;

public class User {
    private String idUser;

    private String idUsap;

    private String numMob;

    private String txtEml;

    private String idCard;

    private String idNotes;

    private String idStaff;

    private String namUser;

    private String codUserSex;

    private String codUserState;

    private String vluUserPwd;

    private Integer vluUserSeq;

    private String codUserType;

    private String idOrg;

    private String namOrg;

    private String idCrtor;

    private String namCrtor;

    private String timeCrt;

    private Integer cntLginFail;

    private String timeLastLginFail;

    private String timeLastMdfPwd;

    private String txtHistPwdLst;

    private String numPho1;

    private String numPho2;

    private String txtUserDscr;

    private String idTeller;

    private String pwdSalt;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser == null ? null : idUser.trim();
    }

    public String getIdUsap() {
        return idUsap;
    }

    public void setIdUsap(String idUsap) {
        this.idUsap = idUsap == null ? null : idUsap.trim();
    }

    public String getNumMob() {
        return numMob;
    }

    public void setNumMob(String numMob) {
        this.numMob = numMob == null ? null : numMob.trim();
    }

    public String getTxtEml() {
        return txtEml;
    }

    public void setTxtEml(String txtEml) {
        this.txtEml = txtEml == null ? null : txtEml.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdNotes() {
        return idNotes;
    }

    public void setIdNotes(String idNotes) {
        this.idNotes = idNotes == null ? null : idNotes.trim();
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff == null ? null : idStaff.trim();
    }

    public String getNamUser() {
        return namUser;
    }

    public void setNamUser(String namUser) {
        this.namUser = namUser == null ? null : namUser.trim();
    }

    public String getCodUserSex() {
        return codUserSex;
    }

    public void setCodUserSex(String codUserSex) {
        this.codUserSex = codUserSex == null ? null : codUserSex.trim();
    }

    public String getCodUserState() {
        return codUserState;
    }

    public void setCodUserState(String codUserState) {
        this.codUserState = codUserState == null ? null : codUserState.trim();
    }

    public String getVluUserPwd() {
        return vluUserPwd;
    }

    public void setVluUserPwd(String vluUserPwd) {
        this.vluUserPwd = vluUserPwd == null ? null : vluUserPwd.trim();
    }

    public Integer getVluUserSeq() {
        return vluUserSeq;
    }

    public void setVluUserSeq(Integer vluUserSeq) {
        this.vluUserSeq = vluUserSeq;
    }

    public String getCodUserType() {
        return codUserType;
    }

    public void setCodUserType(String codUserType) {
        this.codUserType = codUserType == null ? null : codUserType.trim();
    }

    public String getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(String idOrg) {
        this.idOrg = idOrg == null ? null : idOrg.trim();
    }

    public String getNamOrg() {
        return namOrg;
    }

    public void setNamOrg(String namOrg) {
        this.namOrg = namOrg == null ? null : namOrg.trim();
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

    public Integer getCntLginFail() {
        return cntLginFail;
    }

    public void setCntLginFail(Integer cntLginFail) {
        this.cntLginFail = cntLginFail;
    }

    public String getTimeLastLginFail() {
        return timeLastLginFail;
    }

    public void setTimeLastLginFail(String timeLastLginFail) {
        this.timeLastLginFail = timeLastLginFail == null ? null : timeLastLginFail.trim();
    }

    public String getTimeLastMdfPwd() {
        return timeLastMdfPwd;
    }

    public void setTimeLastMdfPwd(String timeLastMdfPwd) {
        this.timeLastMdfPwd = timeLastMdfPwd == null ? null : timeLastMdfPwd.trim();
    }

    public String getTxtHistPwdLst() {
        return txtHistPwdLst;
    }

    public void setTxtHistPwdLst(String txtHistPwdLst) {
        this.txtHistPwdLst = txtHistPwdLst == null ? null : txtHistPwdLst.trim();
    }

    public String getNumPho1() {
        return numPho1;
    }

    public void setNumPho1(String numPho1) {
        this.numPho1 = numPho1 == null ? null : numPho1.trim();
    }

    public String getNumPho2() {
        return numPho2;
    }

    public void setNumPho2(String numPho2) {
        this.numPho2 = numPho2 == null ? null : numPho2.trim();
    }

    public String getTxtUserDscr() {
        return txtUserDscr;
    }

    public void setTxtUserDscr(String txtUserDscr) {
        this.txtUserDscr = txtUserDscr == null ? null : txtUserDscr.trim();
    }

    public String getIdTeller() {
        return idTeller;
    }

    public void setIdTeller(String idTeller) {
        this.idTeller = idTeller == null ? null : idTeller.trim();
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt == null ? null : pwdSalt.trim();
    }
}