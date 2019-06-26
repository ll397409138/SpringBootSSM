package com.carapp.carscrapordermanager.advice;

import com.carapp.carscrapordermanager.common.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BizExceptionHandler {

    /**
     * 用于处理通用异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        String errorMesssage = "校验失败:";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }

        return new ResultBean(400, errorMesssage,"fail");
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean bindException2(BindException e) {
        BindingResult bindingResult = e.getBindingResult();

        String errorMesssage = "校验失败:";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }

        return new ResultBean(400, errorMesssage,"fail");
    }

}
