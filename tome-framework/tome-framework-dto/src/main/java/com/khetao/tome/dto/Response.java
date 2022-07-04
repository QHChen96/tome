package com.khetao.tome.dto;

public class Response extends DTO {

    private static final long serialVersionUID = 1L;

    private String errCode;

    private String errMsg;

    public boolean isSuccess() {
        return errCode == null;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + isSuccess() +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    public static Response buildSuccess() {
        Response response = new Response();
        return response;
    }

    public static Response buildFailure(String errCode, String errMsg) {
        Response response = new Response();
        response.setErrCode(errCode);
        response.setErrMsg(errMsg);
        return response;
    }

}
