package com.nantian.user.domain;

/**
 * @author WangJinYi 2021/3/8
 */
public class JsonResp {

    private String code;
    private String msg;

    public JsonResp(){}

    public JsonResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonResp ok() {
        return new JsonResp("0", "success");
    }

    public static JsonResp ok(String msg) {
        return new JsonResp("0", msg);
    }

    public static JsonResp failure() {
        return new JsonResp("-1", "failure");
    }

    public static JsonResp failure(String msg) {
        return new JsonResp("-1", msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
