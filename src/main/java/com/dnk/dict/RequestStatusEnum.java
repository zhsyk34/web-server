package com.dnk.dict;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RequestStatusEnum {
    ACCEPT(201, ""),//create
    SUBMIT(202, ""),//async accepted
    SUCCESS(200, ""),
    FAIL(500, ""),//server error
    FINISH(203, "");

    private final int code;
    private final String description;

    public static RequestStatusEnum from(int code) {
        for (RequestStatusEnum statusEnum : values()) {
            if (code == statusEnum.code) {
                return statusEnum;
            }
        }
        return null;
    }
}
