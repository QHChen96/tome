package com.khetao.tome.dto;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

@Data
public class CodeMessageResponse extends DTO {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(CodeMessageResponse.class);

    public static final Integer CODE_SUCCESS = 0;
    public static final Integer CODE_FAILURE = 1;
    public static final String MSG_SUCCESS = "SUCCESS";
    public static final String MSG_FAILURE = "FAILURE";

    private Integer code;

    private String message;

    /**
     * 链路追踪
     */
    private String traceId;

    public CodeMessageResponse() {
        this.code = CODE_SUCCESS;
        this.message = MSG_SUCCESS;
    }

    public CodeMessageResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CodeMessageResponse op(Runnable executor) {
        return op(executor, e -> logger.error(e.getMessage(), e));
    }

    public static CodeMessageResponse op(Runnable executor, Consumer<Exception> exceptionConsumer) {
        try {
            executor.run();
            return success();
        } catch (Exception e) {
            exceptionConsumer.accept(e);
            return failure(e.getMessage());
        }
    }

    public static CodeMessageResponse send(Integer code, String message) {
        return new CodeMessageResponse(code, message);
    }

    public static CodeMessageResponse failure(Throwable t) {
        return failure(t.getMessage(), t);
    }

    public static CodeMessageResponse failure(String message, Throwable t) {
        logger.error(t.getMessage(), t);
        return failure(message);
    }

    public static CodeMessageResponse failure(String message) {
        return send(CODE_FAILURE, message);
    }

    public static CodeMessageResponse success(String message) {
        return send(CODE_SUCCESS, message);
    }

    public static CodeMessageResponse success() {
        return send(CODE_SUCCESS, MSG_SUCCESS);
    }

}
