package com.dnk.pubsub.cache;

import com.alibaba.fastjson.JSON;
import com.dnk.dict.redis.cache.Command;
import com.dnk.dict.redis.cache.TcpSession;
import com.dnk.dict.redis.cache.UdpSession;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.dnk.dict.redis.RedisKey.*;

@Service
public final class DefaultRedisCacheAccessor implements RedisCacheAccessor {
    @Resource
    private RedisAccessor redisAccessor;

    @Override
    public TcpSession getTcpSession(@NonNull String sn) {
        return JSON.parseObject(redisAccessor.get(TCP_SESSION, sn), TcpSession.class);
    }

    @Override
    public UdpSession getUdpSession(@NonNull String sn) {
        return JSON.parseObject(redisAccessor.get(TCP_UDP_SESSION, sn), UdpSession.class);
    }

    @Override
    public void reportServerStatus(@NonNull String serverId) {
        redisAccessor.put(WEB_SERVER, serverId, Long.toString(System.currentTimeMillis()));
    }

    @Override
    public void reportServerStatus() {
        this.reportServerStatus("web001");
    }

    @Override
    public void shareAppCommand(@NonNull String sn, @NonNull Command command) {
        redisAccessor.enqueue(sn, JSON.toJSONString(command));
    }

}
