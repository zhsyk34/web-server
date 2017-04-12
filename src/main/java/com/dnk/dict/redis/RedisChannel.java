package com.dnk.dict.redis;

import com.dnk.dict.redis.channel.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 发布/订阅 的管道名称及数据内容
 */
@RequiredArgsConstructor
@Getter
public enum RedisChannel {

    /*--------------------------tcpServer---tcpServer--------------------------*/

    GATEWAY_LOGIN("网关登录通知", GatewayLoginData.class),
    APP_COMMAND_REQUEST("转发app请求", AppCommandRequestData.class),
    APP_COMMAND_RESPONSE("app指令处理结果", AppCommandResponseData.class),

    /*--------------------------tcpServer---webServer--------------------------*/

    WEB_COMMAND_REQUEST("控制指令请求", WebCommandRequestData.class),
    WEB_COMMAND_RESPONSE("控制指令响应", WebCommandResponseData.class),

    /*--------------------------tcpServer---dbServer--------------------------*/

    GATEWAY_VERSION_REQUEST("网关版本查询请求", GatewayVersionRequestData.class),
    GATEWAY_VERSION_RESPONSE("网关版本查询响应", GatewayVersionResponseData.class),
    GATEWAY_MESSAGE_PUSH("网关主动推送(报警)信息", GatewayMessagePushData.class),
    GATEWAY_UDP_PORT_APPLY("网关udp端口申请", GatewayUdpPortApplyData.class),
    GATEWAY_UDP_PORT_ALLOCATE("网关udp端口分配", GatewayUdpPortAllocateData.class);

    private static final Map<String, RedisChannel> CHANNEL_MAP = new HashMap<>();

    static {
        for (RedisChannel redisChannel : values()) {
            CHANNEL_MAP.put(redisChannel.channel(), redisChannel);
        }
    }

    @NonNull
    private final String description;
    @NonNull
    private final Class<?> clazz;

    public static RedisChannel from(String channel) {
        return CHANNEL_MAP.get(channel);
    }

    public final String channel() {
        return this.name().replace("_", ":").toLowerCase();
    }

}
