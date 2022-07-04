package com.khetao.tome.web.exception;

import com.khetao.tome.dto.Response;
import com.khetao.tome.exception.BizException;
import com.khetao.tome.exception.SysException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.MissingWebServerFactoryBeanException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;


/**
 * 统一的异常翻译器
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionTranslator {

    static final Logger logger = LoggerFactory.getLogger(GlobalExceptionTranslator.class);

    @ExceptionHandler(MissingWebServerFactoryBeanException.class)
    public Response handleError(MissingWebServerFactoryBeanException e) {
        return new Response();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response handleError(MethodArgumentTypeMismatchException e) {
        return new Response();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleError(MethodArgumentNotValidException e) {
        return new Response();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response handleError(HttpMediaTypeNotSupportedException e) {
        return new Response();
    }

    @ExceptionHandler(BindException.class)
    public Response handleError(BindException e) {
        return new Response();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Response handleError(ConstraintViolationException e) {
        return new Response();
    }

    @ExceptionHandler(BizException.class)
    public Response handleError(BizException e) {
        return new Response();
    }

    @ExceptionHandler(SysException.class)
    public Response handleError(SysException e) {
        return new Response();
    }

    @ExceptionHandler(Throwable.class)
    public Response handleError(Throwable e) {
        return new Response();
    }
}
