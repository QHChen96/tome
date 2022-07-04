package com.khetao.tome.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.function.Consumer;


/**
 *
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
public abstract class CommonResponse {

    private static final Logger logger = LoggerFactory.getLogger(CommonResponse.class);

    public static javax.ws.rs.core.Response send(Response.Status status, String message) {
        Integer code = status.getFamily() == Response.Status.Family.SUCCESSFUL ? CodeMessage.CODE_SUCCESS : CodeMessage.CODE_FAILURE;
        return Response.status(status).type(MediaType.APPLICATION_JSON).entity(new Object()).build();
    }

    public static javax.ws.rs.core.Response failure(String message) {
        return send(Response.Status.INTERNAL_SERVER_ERROR, message);
    }

    public static javax.ws.rs.core.Response success(String message) {
        return send(Response.Status.OK, message);
    }

    public static javax.ws.rs.core.Response success() {
        return send(Response.Status.OK, "操作成功");
    }

    public static javax.ws.rs.core.Response op(Runnable executor) {
        return op(executor, e -> logger.error(e.getMessage(), e));
    }

    public static javax.ws.rs.core.Response op(Runnable executor, Consumer<Exception> exceptionConsumer) {
        try {
            executor.run();
            return CommonResponse.success();
        } catch (Exception e) {
            exceptionConsumer.accept(e);
            return CommonResponse.failure(e.getMessage());
        }
    }

}
