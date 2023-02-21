package com.rocky.exceptions;

import com.rocky.result.GraceJSONResult;
import com.rocky.result.ResponseStatusEnum;
import com.rocky.result.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * 统一异常拦截处理
 * 可以针对异常的类型进行捕获，然后返回json信息到前端
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public ResultVO returnMyException(MyCustomException e) {
        e.printStackTrace();
        return new ResultVO(e.getResponseStatusEnum());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO returnNormalException(Exception e) {
        String  message = e.getMessage();

        return new ResultVO(ResponseStatusEnum.FAILED,"errMsg",message);
    }



}
