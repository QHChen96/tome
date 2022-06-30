package com.khetao.tome.catchlog;

import com.khetao.tome.dto.Response;
import com.khetao.tome.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseHandler {

    private static final Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    public static Object handle(Class returnType, String errCode, String errMsg){
        if (isResponse(returnType)){
            return handleResponse(returnType, errCode, errMsg);
        }
        return null;
    }

    public static Object handle(Class returnType, BaseException e){
        return handle(returnType, e.getErrCode(), e.getMessage());
    }


    private static Object handleResponse(Class returnType, String errCode, String errMsg) {
        try {
            Response response = (Response)returnType.newInstance();
            response.setSuccess(false);
            response.setErrCode(errCode);
            response.setErrMsg(errMsg);
            return response;
        }
        catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return  null;
        }
    }

    private static boolean isResponse(Class returnType) {
        return  returnType == Response.class || returnType.getGenericSuperclass() == Response.class;
    }

}
