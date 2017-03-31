package com.gongzuochong.enums;


/**
 * 薪资单位.
 */
public enum SalaryUnit{

    Day(1, "元/天"),
    Hour(2, "元/小时"),
    Month(3, "元/月"),
    Time(4, "元/次"),
    Each(5, "元/个");

    private final int value;
    private final String message;

    public static SalaryUnit fromValue(final int value) {
        for (SalaryUnit salaryUnit : SalaryUnit.values()) {
            if (value == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    SalaryUnit(int value, String message) {
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
