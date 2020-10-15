package com.oxygen.mbgtools.utils;

import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 只要有一个为空 就为true
     *
     * @param params Object...
     * @return boolean
     */
    public static boolean isEmptyAnything(Object... params) {
        if (params == null) {
            return true;
        }
        boolean flag = false;
        for (Object param : params) {
            if (param instanceof String) {
                if ("".equals(((String) param).trim())) {
                    flag = true;
                }
            } else {
                if (param == null) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^\\d+$");
    }

    public static String replaceString(String content, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return content;
        }
        Set<Map.Entry<String, String>> sets = map.entrySet();
        for (Map.Entry<String, String> entry : sets) {
            String regex = String.format("\\{%s}", entry.getKey());
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll(entry.getValue());
        }
        return content;
    }

    /**
     * 字符串转数字
     *
     * @param str String
     * @return Integer
     */
    public static Integer cast2Integer(String str) {
        if (isEmptyAnything(str)) return null;
        if (!str.matches("^\\d+$")) return null;
        return Integer.valueOf(str);
    }

    /**
     * 字符串转数字
     *
     * @param str String
     * @return int null时为0
     */
    public static Integer cast2Int(String str) {
        Integer num = cast2Integer(str);
        if (num == null) num = 0;
        return num;
    }

    /**
     * 用户昵称脱敏
     *
     * @param username
     * @return
     */
    public static String usernameEncoder(String username) {
        if (StringUtils.isBlank(username)) {
            return "***";
        }

        int len = username.length();
        if (len == 1) {
            return username + "***";
        }

        return username.substring(0, 1) + "***" + username.substring(len - 1, len);
    }

    public static String getLog(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }

    public static void main(String[] args) {
        isNumeric("");
    }
}
