package com.khetao.tome.dto;

public class SingleResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse buildSuccess() {
        SingleResponse response = new SingleResponse();
        return response;
    }

    public static SingleResponse buildFailure(String errCode, String errMsg) {
        SingleResponse response = new SingleResponse();
        response.setErrCode(errCode);
        response.setErrMsg(errMsg);
        return response;
    }

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setData(data);
        return response;
    }

}
