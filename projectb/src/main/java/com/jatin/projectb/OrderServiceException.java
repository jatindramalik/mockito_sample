package com.jatin.projectb;

public class OrderServiceException extends Exception {

    private String respCode;
    private String respMsg;

    public OrderServiceException(String respCode, String respMsg){
        this.respCode = respCode;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }


}

