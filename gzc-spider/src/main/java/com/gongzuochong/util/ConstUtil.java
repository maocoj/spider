package com.gongzuochong.util;

import java.util.regex.Pattern;

/**
 * Created by marco on 2017/3/30.
 *
 * 自定义一些公用的工具类
 */
public class ConstUtil {
    public static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
    public static boolean checkMobile(String mobile){
        return  MOBILE_PATTERN.matcher(mobile).matches();
    }
}
