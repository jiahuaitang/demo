package com.example.demo.exception;

import com.example.demo.result.AppCode;
import com.example.demo.result.StatusCode;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException(){
        this(1001,"接口错误");
    }

    public APIException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    // 手动设置异常
    public APIException(StatusCode statusCode, String message) {
        // message用于用户设置抛出错误详情，例如：当前价格-5，小于0
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.msg = statusCode.getMsg();
    }

    // 默认异常使用APP_ERROR状态码
    public APIException(String message) {
        super(message);
        this.code = AppCode.APP_ERROR.getCode();
        this.msg = AppCode.APP_ERROR.getMsg();
    }

}
