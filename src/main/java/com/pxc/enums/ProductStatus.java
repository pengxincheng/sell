package com.pxc.enums;

/**
 * Created by pxc on 2018/3/27.
 */
public enum ProductStatus {

    up(0,"上架"),
    down(1,"下架");

    private Integer code;
    private String desc;

    ProductStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
