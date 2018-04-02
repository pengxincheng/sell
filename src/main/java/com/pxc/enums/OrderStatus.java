package com.pxc.enums;

/**
 * Created by pxc on 2018/4/2.
 */
public enum OrderStatus {
    NEW(0, "新订单"),
    FINISHED(1, "已完结"),
    CANCEL(2, "已取消");
    private int code;
    private String message;

    OrderStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
