package com.gongzuochong.enums;

/**
 * Created by marco on 2017/3/28.
 */
public enum GanjiStudyDegree {
    /**
     *     {"t" : "本科","v" : "4"},
     *     {t" : "高中","v" : "2"},
     *     {"t" : "初中","v" : "1"},
           {"t" : "大专","v" : "3"},
           {"t" : "不限","v" : "0"},
           {"t" : "中专/技校","v" : "5"},
           {"t" : "硕士及以上","v" : "6"}
     */
    type0("0", 0, "不限->高中以下"),
    type1("1", 0, "初中->高中以下"),
    type2("2", 1, "高中"),
    type3("3", 3, "大专"),
    type4("4", 4, "本科"),
    type5("5", 2, "中专/技校"),
    type6("6", 5, "硕士及以上");

    String gjCode;
    Integer gzcCode;
    String text;

    GanjiStudyDegree(String gjCode, Integer gzcCode, String text) {
        this.gjCode = gjCode;
        this.gzcCode = gzcCode;
        this.text = text;
    }

    public static GanjiStudyDegree fromGJCode(String code){
        for (GanjiStudyDegree gj : GanjiStudyDegree.values()) {
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
