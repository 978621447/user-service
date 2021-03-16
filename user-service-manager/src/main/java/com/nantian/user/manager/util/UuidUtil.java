package com.nantian.user.manager.util;

import java.util.UUID;

/**
 * @author WangJinYi 2021/3/8
 */
public class UuidUtil {

    public static String newUuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
