package com.pxc.enums;

/**
 * Created by 廖师兄
 * 2017-06-11 17:16
 */

public enum PayStatus {

    WAIT(0, "待支付"),
    SUCCESS(1, "已支付");

    private Integer code;

    private String message;

    PayStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
