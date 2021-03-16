package com.nantian.user.api.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangJinYi 2021/3/8
 */
public class JsonResp {

    private String code;
    private String msg;
    private Map<String, Object> data;

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

    public JsonResp putData(String key, Object value) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(key, value);
        return this;
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
