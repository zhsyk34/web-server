package com.dnk.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Gateway {
    private long id;
    private String sn;
    private String udid;
    private String appId;

    private String name;
    private String type;
    private long gatewayVersionId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
