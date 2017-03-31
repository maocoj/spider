/**
 * $Id: NatureConst.java 40 2015-02-28 13:29:47Z Rex $
 * Copyright(C) 2014-2016 nature.org, All Rights Reserved.
 */
package com.gongzuochong.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 全局常量接口
 *
 * @author <a href="mailto:shiyang.zhao@nature.com">Zhao ShiYang</a>
 * @version 1.0 2014-12-21- 01:26:16
 */
public interface NatureConst {

    /**
     * 组件名称前缀
     */
    String MODULE_NAME_PREFIX = "nature";
    /**
     * 组件名称前缀缩写
     */
    String MODULE_SHORT_NAME_PREFIX = "nt";

    /**
     * 默认连接分隔符
     */
    String DFT_SEPARATOR = "_";
    /**
     * 默认连接分隔符字符
     */
    char DFT_SEPARATOR_CHARACTER = '_';

    /**
     * 默认异常消息
     */
    String DFT_ERROR_MESSAGE = "UNKNOWN ERROR";

    /**
     * 默认字符
     */
    String DFT_CHARSET_NAME = "UTF-8";
    /**
     * 默认字符集
     */
    Charset DFT_CHARSET = Charset.forName(DFT_CHARSET_NAME);

    /**
     * 日期格式
     */
    String DFT_DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 时间格式
     */
    String DFT_TIME_FORMAT = "HH:mm:ss";
    /**
     * 日期时间格式
     */
    String DFT_DATETIME_FORMAT = DFT_DATE_FORMAT + " " + DFT_TIME_FORMAT;

    /**
     * 每秒的毫秒数
     */
    int MILL_SECONDS_PER_SECOND = 1000;
    /**
     * 每分钟秒数
     */
    int SECONDS_PER_MINUTE = 60;
    /**
     * 每分钟毫秒数
     */
    int MILL_SECONDS_PER_MINUTE = MILL_SECONDS_PER_SECOND * SECONDS_PER_MINUTE;
    /**
     * 每小时分钟数
     */
    int MINUTES_PER_HOUR = 60;
    /**
     * 每小时秒数
     */
    int SECONDS_PER_HOUR = MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
    /**
     * 每小时毫秒数
     */
    int MILL_SECONDS_PER_HOUR = SECONDS_PER_HOUR * MILL_SECONDS_PER_SECOND;
    /**
     * 每天小时数
     */
    int HOURS_PER_DAY = 24;
    /**
     * 每天分钟数
     */
    int MINUTES_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR;
    /**
     * 每天秒数
     */
    int SECONDS_PER_DAY = MINUTES_PER_DAY * SECONDS_PER_MINUTE;
    /**
     * 每天毫秒数
     */
    int MILL_SECONDS_SECOND_PER_DAY = SECONDS_PER_DAY * MILL_SECONDS_PER_SECOND;

    /**
     * 默认整数值
     */
    int DFT_INTEGER_VAL = 0;
    /**
     * 默认字节值
     */
    byte DFT_BYTE_VAL = 0;
    /**
     * 默认字符值
     */
    char DFT_CHAR_VAL = ' ';
    /**
     * 默认短整数值
     */
    short DFT_SHORT_VAL = 0;
    /**
     * 默认长整数值
     */
    long DFT_LONG_VAL = 0L;
    /**
     * 默认单精度浮点数值
     */
    float DFT_FLOAT_VAL = 0.0F;
    /**
     * 默认双精度浮点数值
     */
    double DFT_DOUBLE_VAL = 0.0D;
    /**
     * 默认布尔值
     */
    boolean DFT_BOOLEAN_VAL = false;
    /**
     * 默认字符串值
     */
    String DFT_STRING_VAL = "".intern();
    /**
     * 默认字符串值-NULL
     */
    String DFT_NULL_STRING_VAL = "NULL".intern();
    /**
     * 默认大整数数值
     */
    BigInteger DFT_BIGINTEGER_VAL = new BigInteger("0");
    /**
     * 默认大小数数值
     */
    BigDecimal DFT_BIGDECIMAL_VAL = new BigDecimal("0");
    /**
     * 默认日期数值
     */
    Date DFT_DATE_VAL = null;
    /**
     * 默认时间戳值
     */
    Timestamp DFT_TIMESTAMP_VAL = null;

    /**
     * 空字符串
     */
    String EMPTY_STRING = "".intern();
    /**
     * 空Class数组
     */
    Class<?>[] EMPTY_CLASS_ARRAY = new Class[]{};
    /**
     * 空Object数组
     */
    Object[] EMPTY_OBJECT_ARRAY = new Object[]{};
    /**
     * 空整型数组
     */
    int[] EMPTY_INTEGER_ARRAY = new int[]{};
    /**
     * 空整数对象类型数组
     */
    Integer[] EMPTY_INTEGER_WRAP_ARRAY = new Integer[]{};
    /**
     * 空字节类型数组
     */
    byte[] EMPTY_BYTE_ARRAY = new byte[]{};
    /**
     * 空字节对象类型数组
     */
    Byte[] EMPTY_BYTE_WRAP_ARRAY = new Byte[]{};
    /**
     * 空短整数类型数组
     */
    short[] EMPTY_SHORT_ARRAY = new short[]{};
    /**
     * 空短整数对象类型数组
     */
    Short[] EMPTY_SHORT_WRAP_ARRAY = new Short[]{};
    /**
     * 空长整数类型数组
     */
    long[] EMPTY_LONG_ARRAY = new long[]{};
    /**
     * 空长整数对象类型数组
     */
    Long[] EMPTY_LONG_WRAP_ARRAY = new Long[]{};
    /**
     * 空单精度浮点类型数组
     */
    float[] EMPTY_FLOAT_ARRAY = new float[]{};
    /**
     * 空单精度浮点对象类型数组
     */
    Float[] EMPTY_FLOAT_WRAP_ARRAY = new Float[]{};
    /**
     * 空双精度浮点类型数组
     */
    double[] EMPTY_DOUBLE_ARRAY = new double[]{};
    /**
     * 空双精度浮点对象类型数组
     */
    Double[] EMPTY_DOUBLE_WRAP_ARRAY = new Double[]{};
    /**
     * 空布尔类型数组
     */
    boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[]{};
    /**
     * 空布尔对象类型数组
     */
    Boolean[] EMPTY_BOOLEAN_WRAP_ARRAY = new Boolean[]{};
    /**
     * 空字符串类型数组
     */
    String[] EMPTY_STRING_ARRAY = new String[]{};
    /**
     * 空大整数类型数组
     */
    BigInteger[] EMPTY_BIGINTEGER_ARRAY = new BigInteger[]{};
    /**
     * 空大小数类型数组
     */
    BigDecimal[] EMPTY_BIGDECIMAL_ARRAY = new BigDecimal[]{};
    /**
     * 空日期类型数组
     */
    Date[] EMPTY_DATE_ARRAY = new Date[]{};
    /**
     * 空时间戳类型数组
     */
    Timestamp[] EMPTY_TIMESTAMP_ARRAY = new Timestamp[]{};
}
