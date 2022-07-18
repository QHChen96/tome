package com.khetao.tome.dto;

public class SingleResponse<T> extends CodeMessageResponse {

    private static final long serialVersionUID = 1L;

    private T data;

    public SingleResponse() {
        super();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse success() {
        return new SingleResponse();
    }

    public static <T> SingleResponse<T> success(T data) {
        SingleResponse<T> response = success();
        response.setData(data);
        return response;
    }

}
