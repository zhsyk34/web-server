package com.dnk.pubsub.cache;

import com.dnk.dict.redis.cache.Command;
import com.dnk.dict.redis.cache.TcpSession;
import com.dnk.dict.redis.cache.UdpSession;
import lombok.NonNull;

/**
 * redis-Server数据读写
 */
public interface RedisCacheAccessor {

    /**
     * @param sn 网关序列号
     * @return 获取网关tcp连接信息:判断是否在线
     */
    TcpSession getTcpSession(@NonNull String sn);

    /**
     * @param sn 网关序列号
     * @return 网关udp心跳信息
     */
    UdpSession getUdpSession(@NonNull String sn);

    /**
     * (定时)上报服务器状态
     *
     * @param serverId 服务器编号
     */
    void reportServerStatus(@NonNull String serverId);

    /**
     * 上报本服务器的状态
     *
     * @see #reportServerStatus(String)
     */
    void reportServerStatus();

    /**
     * 提交(共享)app的请求指令
     *
     * @param serverId 服务器编号
     * @param command  请求指令
     */
    void shareAppCommand(@NonNull String serverId, @NonNull Command command);

}
