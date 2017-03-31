package com.gongzuochong.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * job 1级大类.
 */
public enum JobCateFirst {

    QZ(1, "全职"),
    JZ(68, "兼职"),;

    private final int value;
    private final String message;

    public static JobCateFirst fromValue(final int value) {
        for (JobCateFirst salaryUnit : JobCateFirst.values()) {
            if (value == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    public static List<JobCateFirst> fromValues(final Iterable<Integer> codes) {

        List<JobCateFirst> jobTags = new ArrayList<>();

        for (Integer code : codes) {

            final JobCateFirst jobTag = fromValue(code);

            if (jobTag != null) {
                jobTags.add(jobTag);
            }
        }

        return jobTags;
    }

    JobCateFirst(int value, String message) {
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
