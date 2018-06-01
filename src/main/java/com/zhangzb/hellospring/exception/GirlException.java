package com.zhangzb.hellospring.exception;


import com.zhangzb.hellospring.enums.ResultEnums;

public class GirlException extends  RuntimeException{

    private  Integer code;

    public GirlException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
