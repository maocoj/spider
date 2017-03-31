package com.gongzuochong.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * job状态.
 */
public enum JobState {

    State0(0, "待审核"),
    State1(1, "招聘中"),
    State2(2, "未审核通过"),
//    State3(3, "已下架(过期)"), dic.xml中是已下架(过期)"
    State3(3, "已停招"),
    State4(4, "已招满"),
    State5(5, "被举报违规"),
    State6(6, "审核确认违规"),
    State7(7, "公司审核未通过"),
    State8(8, "客户主动暂停招聘"),
    State9(9, "审核暂停招聘"),
    State10(10, "已删除");

    private final int value;
    private final String message;

    public static JobState fromValue(final int value) {
        for (JobState salaryUnit : JobState.values()) {
            if (value == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    public static List<JobState> fromValues(final Iterable<Integer> codes) {

        List<JobState> jobTags = new ArrayList<>();

        for (Integer code : codes) {

            final JobState jobTag = fromValue(code);

            if (jobTag != null) {
                jobTags.add(jobTag);
            }
        }

        return jobTags;
    }

    JobState(int value, String message) {
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
