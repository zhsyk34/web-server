package com.dnk.entity;

import com.dnk.dict.RequestStatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Request {
    private long id;
    private String sn;//请求编号
    private String uuid;//锁编号
    private String action;//请求类型
    private String params;//请求参数
    private String appId;//请求者身份
    private String callback;//请求提供的回调地址
    private LocalDateTime acceptTime;
    private LocalDateTime finishTime;
    private LocalDateTime callbackTime;
    private RequestStatusEnum status;
}
