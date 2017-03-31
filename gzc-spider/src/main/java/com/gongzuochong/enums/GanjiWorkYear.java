package com.gongzuochong.enums;

/**
 * Created by marco on 2017/3/28.
 * 赶集的workyear与工作虫一致
 */
public enum GanjiWorkYear {
    type0("0", 0, "不限"),
    type1("1", 1, "1年以下"),
    type2("2", 2, "1-3年"),
    type3("3", 3, "3－5年"),
    type4("4", 4, "5－10年"),
    type5("5", 5, "10年以上");

    String gjCode;
    Integer gzcCode;
    String text;

    GanjiWorkYear(String gjCode, Integer gzcCode, String text) {
        this.gjCode = gjCode;
        this.gzcCode = gzcCode;
        this.text = text;
    }

    public static GanjiWorkYear fromGJCode(String code){
        for (GanjiWorkYear gj : GanjiWorkYear.values()) {
            if (gj.getGjCode().equals(code)) {
                return gj;
            }
        }
        return null;
    }

    public String getGjCode() {
        return gjCode;
    }

    public void setGjCode(String gjCode) {
        this.gjCode = gjCode;
    }

    public Integer getGzcCode() {
        return gzcCode;
    }

    public void setGzcCode(Integer gzcCode) {
        this.gzcCode = gzcCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
