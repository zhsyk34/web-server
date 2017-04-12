package com.dnk.dict;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SwitchStateEnum {
    UNKNOWN(255, "未知"),
    OPENED(0, "开启"),
    CLOSED(1, "关闭");

    private final int code;
    private final String description;

    public static SwitchStateEnum from(int code) {
        for (SwitchStateEnum stateEnum : values()) {
            if (code == stateEnum.code) {
                return stateEnum;
            }
        }
        return null;
    }
}
