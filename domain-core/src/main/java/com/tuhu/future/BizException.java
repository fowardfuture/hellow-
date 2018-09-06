package com.tuhu.future;

/**
 * @author yangcheng1
 * @Title: BizException
 * @ProjectName future-mybatis-parent
 * @Description: 自定义异常
 * @date 2018/7/1122:42
 */
public class BizException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BizException(String message) {
        super(message);
    }


}
