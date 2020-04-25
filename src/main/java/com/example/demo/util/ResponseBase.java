package com.example.demo.util;

import lombok.Data;

@Data
public class ResponseBase<T> {
    T data;
    String msg;
    String code;

    public ResponseBase() {
        this.code = "200";
        this.msg = "OK";
    }

    public ResponseBase(T data) {
        this.data = data;
    }

    public ResponseBase(String code, String msg) {
        this.code = "200";
        this.msg = "OK";
    }
}
