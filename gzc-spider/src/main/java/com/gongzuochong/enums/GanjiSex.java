package com.gongzuochong.enums;

/**
 * Created by marco on 2017/3/28.
 */
public enum GanjiSex {
    /**
     [
         {"t" : "不限","v" : "0"},
         {"t" : "男","v" : "1"},
         {"t" : "女","v" : "2"}
     */
    type0("0", 0, "不限"),
    type1("1", 1, "男"),
    type2("2", 2, "女");


    String gjCode;
    Integer gzcCode;
    String text;

    GanjiSex(String gjCode, Integer gzcCode, String text) {
        this.gjCode = gjCode;
        this.gzcCode = gzcCode;
        this.text = text;
    }

    public static GanjiSex fromGJCode(String code){
        for (GanjiSex gj : GanjiSex.values()) {
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
