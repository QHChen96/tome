package com.khetao.tome.catchlog;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.khetao.tome.dto.CodeMessageResponse;
import com.khetao.tome.exception.BaseException;
import com.khetao.tome.exception.BizException;
import com.khetao.tome.exception.SysException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class CatchLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(CatchLogAspect.class);

    @Pointcut("@within(CatchLog) && execution(public * *(..))")
    public void pointcut() {}

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime =  System.currentTimeMillis();

        logRequest(joinPoint);

        Object response = null;
        try {
            response = joinPoint.proceed();
        }
        catch (Throwable e){
            response = handleException(joinPoint, e);
        }
        finally {
            logResponse(startTime, response);
        }

        return response ;
    }

    private Object handleException(ProceedingJoinPoint joinPoint, Throwable e) {
        if (e instanceof BizException){
            logger.warn("BIZ EXCEPTION : " + e.getMessage());
            //在Debug的时候，对于BizException也打印堆栈
            if(logger.isDebugEnabled()){
                logger.error(e.getMessage(), e);
            }
            return CodeMessageResponse.failure(e);
        }

        if (e instanceof SysException){
            logger.error("SYS EXCEPTION :");
            logger.error(e.getMessage(), e);
            return CodeMessageResponse.failure(e);
        }

        logger.error("UNKNOWN EXCEPTION :");
        logger.error(e.getMessage(), e);
        return CodeMessageResponse.failure("UNKNOWN_ERROR", e);
    }


    private void logResponse(long startTime, Object response) {
        try{
            long endTime =  System.currentTimeMillis();
            logger.debug("RESPONSE : "+ JSON.toJSONString(response) );
            logger.debug("COST : " + (endTime - startTime) + "ms");
        }
        catch (Exception e){
            //swallow it
            logger.error("logResponse error : " + e);
        }
    }

    private void logRequest(ProceedingJoinPoint joinPoint) {
        try {
            if (!logger.isDebugEnabled()) {
                return;
            }
            logger.debug("START PROCESSING: " + joinPoint.getSignature().toShortString());
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                logger.debug("REQUEST : " + JSON.toJSONString(arg, JSONWriter.Feature.IgnoreErrorGetter));
            }
        }
        catch (Exception e){
            //swallow it
            logger.error("logReqeust error : " + e);
        }
    }
}
