package com.gongzuochong.enums;


import java.util.EnumSet;

/**
 * JobSource.
 */
public enum JobSource {
    Gzc(0, "工作虫"),
    ZM(1,"众盟"),
    Meicai(2, "美菜"),
    Wuba(3, "58"),
    Doumi(4, "斗米"),
    Ganji(5,"赶集");

    private final int value;
    private final String description;

    public static JobSource fromValue(final int value) {
        for (JobSource salaryUnit : JobSource.values()) {
            if (value == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    public static EnumSet<JobSource> fromValues(final Iterable<Integer> codes) {

        EnumSet<JobSource> jobTags = EnumSet.noneOf(JobSource.class);

        for (Integer code : codes) {

            final JobSource jobTag = fromValue(code);

            if (jobTag != null) {
                jobTags.add(jobTag);
            }
        }

        return jobTags;
    }

    JobSource(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
