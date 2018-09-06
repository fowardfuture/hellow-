package com.tuhu.future.Enum;


public enum OrderStatus {

    ORDER_DONE(1,"已下单"),ORDER_CANCLE(2,"取消订单"),ORDER_UNPICK(3,"订单未领取"),ORDER_SURE(4,"订单已确认");

    private Integer code;
    private String msg;

    OrderStatus(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
