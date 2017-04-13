package com.dnk.controller;

import com.dnk.exception.CustomException;
import com.dnk.exception.ResultEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
public class Result<T> {
    private final int code;
    private final String message;
    private final T data;

    private Result(ResultEnum resultEnum, T t) {
        this(resultEnum.getCode(), resultEnum.getMessage(), t);
    }

    public static <T> Result<T> from(ResultEnum resultEnum, T t) {
        return new Result<>(resultEnum, t);
    }

    public static <T> Result<T> from(ResultEnum resultEnum) {
        return from(resultEnum, null);
    }

    public static <T> Result<T> success(T t) {
        return from(ResultEnum.SUCCESS, t);
    }

    public static Result success() {
        return from(ResultEnum.SUCCESS, null);
    }

    public static Result error(CustomException ce) {
        return new Result<>(ce.getCode(), ce.getMessage(), null);
    }

}
