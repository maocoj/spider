/**
 * $Id: StringUtil.java 40 2015-02-28 13:29:47Z Rex $
 * Copyright(C) 2014-2016 nature.org, All Rights Reserved.
 */
package com.gongzuochong.config;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 字符串工具类
 *
 * @author <a href="mailto:shiyang.zhao@nature.com">Zhao ShiYang</a>
 * @version 1.0 2015-02-06 17:54:54
 */
public class StringUtil {
    /**
     * 单例
     */
    private static final StringUtil instance = new StringUtil();

    /**
     * 随机数对象
     */
    private static final Random random = new Random();

    /**
     * 数字与字母字典
     */
    private static final char[] LETTER_AND_DIGIT = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    /**
     * 数字与字母字典长度
     */
    private static final int LETTER_AND_DIGIT_LENGTH = LETTER_AND_DIGIT.length;

    private StringUtil() {
    }

    /**
     * 取得该类唯一实例
     *
     * @return 该类唯实例
     */
    public static StringUtil instance() {
        return instance;
    }

    /**
     * 检测字符串是否为空字符串
     * 字符串为空的标准：null或全部由空字符组成的字符串
     *
     * @param str 待检测字符串
     * @return <li>true：字符串是空字符串</li>
     * <li>false：字符串不是空字符串</li>
     * @see #isNotEmpty(String)
     */
    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    /**
     * 检测字符串是否不为空字符串
     * 字符串为空的标准：null或全部由空字符组成的字符串
     *
     * @param str 待检测字符串
     * @return <li>true：字符串不是空字符串</li>
     * <li>false：字符串是空字符串</li>
     * @see #isEmpty(String)
     */
    public static boolean isNotEmpty(String str) {

        // 空指针，返回false
        if (str == null) return false;

        char ch;
        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            // 发现非空字符，返回true
            if (ch > ' ') return true;
        }

        // 遍历结束，未发现非空字符，返回false
        return false;
    }

    /**
     * 将对象转换为字符串
     *
     * @param input 待转换对象
     * @return 转换后的字符串
     * @see #getString(Object, String)
     * @see #getString(String)
     * @see #getString(String, String)
     */
    public static String getString(Object input) {
        return getString(input, NatureConst.DFT_STRING_VAL);
    }

    /**
     * 将对象转换为字符串
     *
     * @param input  待转换对象
     * @param defVal 对象转换为空字符串时的默认返回值
     * @return 转换后的字符串
     * @see #getString(String)
     * @see #getString(String, String)
     */
    public static String getString(Object input, String defVal) {
        return (input == null) ? defVal : getString(input.toString(), defVal);
    }

    /**
     * 转换字符串
     *
     * @param input 待转换字符串
     * @return 转换后的字符串
     * @see #getString(String, String)
     */
    public static String getString(String input) {
        return getString(input, NatureConst.DFT_STRING_VAL);
    }

    /**
     * 转换字符串
     *
     * @param input  待转换字符串
     * @param defVal 默认转换值
     * @return 转换后的字符串
     * <li>字符串为null或全部由空白字符组成的字符串时，返回defVal参数指定的值</li>
     * <li>其他情况，返回去掉字符串两端空白字符后的字符串</li>
     */
    public static String getString(String input, String defVal) {
        return isEmpty(input) ? defVal : input.trim();
    }

    /**
     * 生成固定长度的随机字符串
     *
     * @param len 随机字符串长度
     * @return 生成的随机字符串
     * @see #randomString(int, char[])
     */
    public static String randomString(final int len) {
        return randomString(len, LETTER_AND_DIGIT, LETTER_AND_DIGIT_LENGTH);
    }

    /**
     * 生成固定长度的随机字符串
     *
     * @param len        随机字符串长度
     * @param dictionary 字符串字典
     * @return 生成的随机字符串
     */
    public static String randomString(final int len, char[] dictionary) {

        if (dictionary == null || dictionary.length == 0)
            throw new RuntimeException("Dictionary can't be empty.");

        // 生成长度小于1时，返回空字符串
        if (len < 1) return NatureConst.DFT_STRING_VAL;

        // 生成随机字符串
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(dictionary[random.nextInt(dictionary.length)]);
        }

        // 返回
        return sb.toString();
    }

    private static String randomString(int length, char[] dictionary, int dicLength) {

        // 生成长度小于1时，返回空字符串
        if (length < 1) return NatureConst.DFT_STRING_VAL;

        // 生成随机字符串
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(dictionary[random.nextInt(dicLength)]);
        }

        // 返回
        return sb.toString();
    }

    /**
     * 创建一个新的字符串
     *
     * @param bytes 字符串内容字节数组(UTF-8编码)
     * @return 新创建的字符串
     * @see #newString(byte[], String)
     */
    public static String newString(byte[] bytes) {
        return newString(bytes, NatureConst.DFT_CHARSET);
    }

    /**
     * 创建一个新的字符串
     *
     * @param bytes   字符串内容字节数组
     * @param charset 字符串字节编码
     * @return 新创建的字符串
     */
    public static String newString(byte[] bytes, String charset) {
        return new String(bytes, Charset.forName(charset));
    }

    /**
     * 创建一个新的字符串
     *
     * @param bytes   字符串内容字节数组
     * @param charset 字符串字节编码
     * @return 新创建的字符串
     */
    public static String newString(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

    /**
     * 取得字符串字节数组
     *
     * @param str 字符串
     * @return 字符串内容字节数组
     * @see #getBytes(String, String)
     */
    public static byte[] getBytes(String str) {
        return getBytes(str, NatureConst.DFT_CHARSET);
    }

    /**
     * 取得字符串字节数组
     *
     * @param str     字符串
     * @param charset 字符串字节编码
     * @return 字符串内容字节数组
     */
    public static byte[] getBytes(String str, String charset) {
        return getBytes(str, Charset.forName(charset));
    }

    /**
     * 取得字符串字节数组
     *
     * @param str     字符串
     * @param charset 字符串字节编码
     * @return 字符串内容字节数组
     */
    public static byte[] getBytes(String str, Charset charset) {
        return (str == null) ? null : str.getBytes(charset);
    }

    /**
     * 从左侧开始截取固定长度的字符串
     *
     * @param str    待截取字符串
     * @param length 截取的长度
     * @return <li>字符串为空，或截取长度小于1，或截取长度大于字符串长度时，返回空字符串</li>
     * <li>其他情况，返回截取的字符串</li>
     */
    public static String left(String str, int length) {
        return (str == null || length < 1 || str.length() < length) ?
                NatureConst.DFT_STRING_VAL : str.substring(0, length);
    }

    /**
     * 从右侧开始截取固定长度的字符串
     *
     * @param str    待截取字符串
     * @param length 截取的长度
     * @return <li>字符串为空，或截取长度小于1，或截取长度大于字符串长度时，返回空字符串</li>
     * <li>其他情况，返回截取的字符串</li>
     */
    public static String right(String str, int length) {
        return (str == null || str.length() < length) ?
                NatureConst.DFT_STRING_VAL : str.substring(str.length() - length);
    }

    /**
     * 将数组中字符串按照分隔符连接成一个字符串
     *
     * @param seperator 分隔符
     * @param params    待连接字符串数组
     * @return 连接后的字符串
     */
    public static String join(String seperator, Object... params) {
        return joinArray(seperator, params);
    }

    /**
     * 将数组中字符串按照分隔符连接成一个字符串
     *
     * @param seperator 分隔符
     * @param params    待连接字符串数组
     * @return 连接后的字符串
     */
    public static String joinArray(String seperator, Object[] params) {

        if (params == null || params.length == 0) return NatureConst.DFT_STRING_VAL;

        StringBuilder ret = new StringBuilder();
        for (Object param : params) {
            if (param == null) continue;
            if (ret.length() > 0) ret.append(seperator);
            if (param.getClass().isArray()) {
                ret.append(joinArray(seperator, (Object[]) param));
            } else {
                ret.append(param);
            }
        }
        return ret.toString();
    }

    /**
     * 比较两个字符串大小
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return <li>-1：str1小</li>
     * <li>0：两字符串相等</li>
     * <li>1：str2小</li>
     */
    public static int compare(String str1, String str2) {
        if (str1 == null && str2 == null) return 0;
        if (str1 == null) return -1;
        if (str2 == null) return 1;

        int len1 = str1.length();
        int len2 = str2.length();
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 == ch2) continue;
            return (ch1 < ch2) ? -1 : 1;
        }

        if (len1 == len2) return 0;
        return (len1 < len2) ? -1 : 1;
    }

    /**
     * 过滤空格
     *
     * @param str 待过滤字符串
     * @return <li>字符串为null时，返回null</li>
     * <li>其他情况，返回str.trim()</li>
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 简单替换字符串中的内容
     *
     * @param str  待替换的字符串
     * @param from 待替换的字符
     * @param to   替换后的字符
     * @return 替换后的结果
     */
    public static String replaceAll(String str, char from, char to) {

        StringBuilder ret = new StringBuilder();
        char ch;

        int length = str.length();
        for (int i = 0; i < length; i++) {
            ch = str.charAt(i);
            ret.append((ch == from) ? to : ch);
        }

        return ret.toString();
    }

    public static List<String> toList(String str, final char seperator) {

        List<String> ret = new ArrayList<>();
        if (isEmpty(str)) return ret;

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == seperator) {
                ret.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }

        if (sb.length() > 0)
            ret.add(sb.toString());

        return ret;
    }

    public static boolean equals(String s1, String s2) {
        return (s1 == null) ? (s2 == null) : s1.equals(s2);
    }

    public static boolean notEquals(String s1, String s2) {
        return !equals(s1, s2);
    }

    /**
     * 通配符算法。 可以匹配"*"和"?"
     * 如a*b?d可以匹配aAAAbcd
     *
     * @param pattern 匹配表达式
     * @param str     匹配的字符串
     * @return
     */
    public static boolean match(String pattern, String str) {
        if (pattern == null || str == null)
            return false;

        boolean result = false;
        char c; // 当前要匹配的字符串
        boolean beforeStar = false; // 是否遇到通配符*
        int back_i = 0;// 回溯,当遇到通配符时,匹配不成功则回溯
        int back_j = 0;
        int i, j;
        for (i = 0, j = 0; i < str.length(); ) {
            if (pattern.length() <= j) {
                if (back_i != 0) {// 有通配符,但是匹配未成功,回溯
                    beforeStar = true;
                    i = back_i;
                    j = back_j;
                    back_i = 0;
                    back_j = 0;
                    continue;
                }
                break;
            }

            if ((c = pattern.charAt(j)) == '*') {
                if (j == pattern.length() - 1) {// 通配符已经在末尾,返回true
                    result = true;
                    break;
                }
                beforeStar = true;
                j++;
                continue;
            }

            if (beforeStar) {
                if (str.charAt(i) == c) {
                    beforeStar = false;
                    back_i = i + 1;
                    back_j = j;
                    j++;
                }
            } else {
                if (c != '?' && c != str.charAt(i)) {
                    result = false;
                    if (back_i != 0) {// 有通配符,但是匹配未成功,回溯
                        beforeStar = true;
                        i = back_i;
                        j = back_j;
                        back_i = 0;
                        back_j = 0;
                        continue;
                    }
                    break;
                }
                j++;
            }
            i++;
        }

        if (i == str.length() && j == pattern.length())// 全部遍历完毕
            result = true;
        return result;
    }

}
