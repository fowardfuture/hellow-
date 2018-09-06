package com.tuhu.future.Util;

/**
 * @author yangcheng1
 * @Title: ApiResult
 * @ProjectName future-mybatis-parent
 * @Description: TODO
 * @date 2018/7/1122:52
 */
public class ApiResult {

    /** 返回结果码*/
    private Integer code;

    /** 返回结果信息*/
    private String msg;

    /** 返回结果数据*/
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
