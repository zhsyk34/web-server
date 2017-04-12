package com.dnk.entity;

import com.dnk.dict.SwitchStateEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.dnk.dict.SwitchStateEnum.UNKNOWN;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Lock {
    private long id;
    private String uuid;
    private long gatewayId;
    private long deviceIndex;
    private String name;
    private boolean available;

    private String superPassword;
    private String tempPassword;

    private SwitchStateEnum locked = UNKNOWN;
    private SwitchStateEnum upLocked = UNKNOWN;
    private SwitchStateEnum backLocked = UNKNOWN;
    private SwitchStateEnum online = UNKNOWN;
    private int voltage = UNKNOWN.getCode();

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime pushTime;
}
