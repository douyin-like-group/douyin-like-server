package com.rocky.exceptions;


import com.rocky.result.ResponseStatusEnum;

/**
 * 优雅的处理异常，统一封装
 */
public class GlobalException {

    public static void display(ResponseStatusEnum responseStatusEnum) {
        throw new MyCustomException(responseStatusEnum);
    }

}
