package com.gongzuochong.enums;


import java.util.EnumSet;

/**
 * 薪资单位.
 */
public enum JobTag  {

    Type1(1, "包吃"),
    Type2(2, "包住"),
    Type3(3, "包吃住"),
    Type4(4, "五险一金"),
    Type5(5, "周末双休"),
    Type6(6, "带薪年假"),
    Type7(7, "饭补"),
    Type8(8, "话补"),
    Type9(9, "加班补助"),
    Type10(10, "交通补助");

    private final int value;
    private final String message;

    public static JobTag fromValue(final int value) {
        for (JobTag salaryUnit : JobTag.values()) {
            if (value == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    public static EnumSet<JobTag> fromValues(final Iterable<Integer> codes) {

        EnumSet<JobTag> jobTags = EnumSet.noneOf(JobTag.class);

        for (Integer code : codes) {

            final JobTag jobTag = fromValue(code);

            if (jobTag != null) {
                jobTags.add(jobTag);
            }
        }

        return jobTags;
    }

    JobTag(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return message;
    }

}
