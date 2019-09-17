package com.wr.mypracticespringboot.enums;

import lombok.Getter;

/**
 * @author wangru
 * @create 2019-09-06 16:48
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
