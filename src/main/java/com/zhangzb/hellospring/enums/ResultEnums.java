package com.zhangzb.hellospring.enums;

public enum ResultEnums {
    UNKNONW_ERROE(-1,"未知错误"),
    SUCCESS(0,"SUCCESS"),
    PRIMARY_SCHOOL(100,"小学生报道哈哈"),
    MIDDLE_SCHOOL(101,"初中生了呢！"),
    ;

    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
