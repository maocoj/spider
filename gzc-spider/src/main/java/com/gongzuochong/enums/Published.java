package com.gongzuochong.enums;

/**
 * Created by marco on 2017/3/27.
 */
public enum Published {
    None(null,"无此字段"),
    Yes(1 ,"已发布"),
    No(0, "未发布"),
    err(-1,"导入错误");

    private Integer code;
    private String text;
    Published(Integer code , String text){
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
