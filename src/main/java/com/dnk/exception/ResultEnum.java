package com.dnk.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
    UNKNOWN(-1, "未知错误"),
    param(100, "参数非法"),
    auth(500, "权限错误");

    private final int code;
    private final String message;
}
