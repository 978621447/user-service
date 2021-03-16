package com.nantian.user.manager.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author WangJinYi 2021/3/8
 */
public class MD5Util {

    /**
     * 计算md5值
     *
     * @param originalStr 源字符串
     * @return MD5
     */
    public static String getMd5(String originalStr) {
        if(originalStr == null) {
            return "";
        } else {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5计算异常");
            }
            md.update(originalStr.getBytes());
            byte[] by = md.digest();
            int i;
            StringBuilder buf = new StringBuilder("");
            for (byte b : by) {
                i = b;
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        }
    }

}
