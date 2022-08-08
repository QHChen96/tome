package com.khetao.tome.web.exception;

import com.khetao.tome.dto.CodeMessageResponse;
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
    public CodeMessageResponse handleError(MissingWebServerFactoryBeanException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CodeMessageResponse handleError(MethodArgumentTypeMismatchException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CodeMessageResponse handleError(MethodArgumentNotValidException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public CodeMessageResponse handleError(HttpMediaTypeNotSupportedException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(BindException.class)
    public CodeMessageResponse handleError(BindException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public CodeMessageResponse handleError(ConstraintViolationException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(BizException.class)
    public CodeMessageResponse handleError(BizException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(SysException.class)
    public CodeMessageResponse handleError(SysException e) {
        return CodeMessageResponse.failure(e);
    }

    @ExceptionHandler(Throwable.class)
    public CodeMessageResponse handleError(Throwable e) {
        return CodeMessageResponse.failure(e);
    }
}
