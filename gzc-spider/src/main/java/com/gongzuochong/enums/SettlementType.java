package com.gongzuochong.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * 工资结算.
 */
public enum SettlementType {

//    <configuration code="dic" type="settlement_type">
//    <property code="settlement_type_0" value="0" text="日结" order="0" description="结算方式"/>
//    <property code="settlement_type_1" value="1" text="周结" order="1" description="结算方式"/>
//    <property code="settlement_type_2" value="2" text="月结" order="2" description="结算方式"/>
//    <property code="settlement_type_3" value="3" text="完工结" order="3" description="结算方式"/>
//  </configuration>


    Day(0, "日结"),
    Week(1, "周结"),
    Month(2, "月结"),
    Finish(3, "完工结"),;

    private final int value;
    private final String message;

    public static SettlementType fromValue(final int value) {
        for (SettlementType salaryUnit : SettlementType.values()) {
            if (value == salaryUnit.getValue()) {
                return salaryUnit;
            }
        }

        return null;
    }

    public static List<SettlementType> fromValues(final Iterable<Integer> codes) {

        List<SettlementType> jobTags = new ArrayList<>();

        for (Integer code : codes) {

            final SettlementType jobTag = fromValue(code);

            if (jobTag != null) {
                jobTags.add(jobTag);
            }
        }

        return jobTags;
    }

    SettlementType(int value, String message) {
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
