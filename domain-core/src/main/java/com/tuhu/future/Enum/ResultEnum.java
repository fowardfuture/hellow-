package com.tuhu.future.Enum;

public enum ResultEnum {
    SUCCESS("成功",0),FAIL("失败",1)
    ;

    private String msg;
    private Integer code;

    ResultEnum (String msg,Integer code){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
