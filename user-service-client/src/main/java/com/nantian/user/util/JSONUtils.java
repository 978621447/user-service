package com.nantian.user.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author WangJinYi 2021/3/8
 */
public class JSONUtils {

    /**
     * json转换成对象
     *
     * @param clazz 对象class
     * @param jsonStr 源json字符串
     * @param <T> 对象类型
     * @return 对象
     */
    public static <T> T jsonToObj(Class<T> clazz,String jsonStr) {
        T result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            throw new RuntimeException("json转对象异常");
        }
        return result;
    }

    /**
     * 对象转换成json
     *
     * @param obj 对象
     * @return json字符串
     */
    public static String objToJson(Object obj) {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("对象转json异常");
        }
        return result;
    }

}
