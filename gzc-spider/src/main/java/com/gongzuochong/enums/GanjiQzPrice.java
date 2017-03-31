package com.gongzuochong.enums;

/**
 * Created by marco on 2017/3/28.
 */
public enum GanjiQzPrice {
    /**
     [

         {"t" : "面议",          "v" : "0"},
         {"t" : "1000元以下",     "v" : "1"},
         {"t" : "1000-2000元",   "v" : "2"},
         {"t" : "2000-3000元",   "v" : "3"},
         {"t" : "3000-5000元",   "v" : "4"},
         {"t" : "5000-8000元",   "v" : "5"},
         {"t" : "8000-12000元",  "v" : "6"},
         {"t" : "12000-20000元", "v" : "7"},
         {"t" : "20000元以上",    "v" : "8"},
         {"t" : null,            "v" : "500"}
     ]
     */
    type0("0", 1, 1720, "面议"),
    type1("1", 2, 1000, "1000元以下"),
    type2("2", 3, 1500, "1000-2000元"),
    type3("3", 4, 2500, "2000-3000元"),
    type4("4", 5, 4000, "3000-5000元"),
    type5("5", 6, 6000, "5000-8000元"),
    type6("6", 7, 10000, "8000-12000元"),
    type7("7", 8, 16000, "12000-20000元"),
    type8("8", 9, 200000, "20000元以上");

    String gjCode;
    Integer gzcCode;
    Integer defaultPay;
    String text;

    GanjiQzPrice(String gjCode, Integer gzcCode, Integer defaultPay, String text) {
        this.gjCode = gjCode;
        this.gzcCode = gzcCode;
        this.defaultPay = defaultPay;
        this.text = text;
    }

    public static GanjiQzPrice fromGJCode(String code){
        for (GanjiQzPrice gj : GanjiQzPrice.values()) {
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

    public Integer getDefaultPay() {
        return defaultPay;
    }

    public void setDefaultPay(Integer defaultPay) {
        this.defaultPay = defaultPay;
    }
}
