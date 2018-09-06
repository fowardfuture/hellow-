package com.tuhu.future.controller;

import com.tuhu.future.BizException;
import com.tuhu.future.Enum.ResultEnum;
import com.tuhu.future.Util.ApiResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangcheng1
 * @Title: ExceptionHandleAdvice
 * @ProjectName future-mybatis-parent
 * @Description: 异常加强处理类
 * @date 2018/7/138:57
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandleAdvice {

    @ExceptionHandler(BizException.class)
    public ApiResult handleIllegalParamException(BizException e) {
        
        String tips = e.getMessage();
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(ResultEnum.FAIL.getCode());
        apiResult.setMsg(tips);
        return apiResult;
    }

}
