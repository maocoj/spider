package com.gongzuochong.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * 三方注册用户来源.
 */
public enum ThirdUserType {
    GZC(0, "工作虫"),
    ZM(1, "众盟"),
    Meicai(2,"美菜"),
    Wuba(3,"58"),
    Doumi(4,"斗米"),
    Ganji(5, "赶集")
    ;



    private final int code;
    private final String message;

    public static ThirdUserType fromValue(final int code) {
        for (ThirdUserType salaryUnit : ThirdUserType.values()) {
            if (code == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    public static List<ThirdUserType> fromValues(final Iterable<Integer> codes) {

        List<ThirdUserType> jobTags = new ArrayList<>();

        for (Integer code : codes) {

            final ThirdUserType jobTag = fromValue(code);

            if (jobTag != null) {
                jobTags.add(jobTag);
            }
        }

        return jobTags;
    }

    ThirdUserType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getValue() {
        return code;
    }

    public String getDescription() {
        return message;
    }

}