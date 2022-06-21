package com.example.demo.result;

import lombok.Getter;

@Getter
public enum AppCode implements StatusCode {
    APP_ERROR(2000, "业务异常"),
    PRICE_ERROR(2001, "价格异常"),
    ID_NOT_EXIST(2002, "id不存在");

    private int code;
    private String msg;

    AppCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
