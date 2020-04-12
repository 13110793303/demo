package com.cq.demo.util;

/**
 * @Author: ChengYangChang
 */
public class StringUtil {

    public static boolean isNull(Object object) {
        if (object != null) {
            return String.valueOf(object).length() <= 0;
        }
        return true;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 字符反转
     */
    public static String reverseString(String str) {
        if (str != null && str.length() > 0) {
            int len = str.length();
            char[] chars = new char[len];
            for (int i = len - 1; i >= 0; i--) {
                chars[len - 1 - i] = str.charAt(i);
            }
            return new String(chars);
        }
        return str;
    }

}
