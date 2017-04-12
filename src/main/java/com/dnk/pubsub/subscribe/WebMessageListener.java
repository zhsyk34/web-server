package com.dnk.pubsub.subscribe;

import com.alibaba.fastjson.JSON;
import com.dnk.dict.redis.RedisChannel;
import com.dnk.dict.redis.channel.WebCommandResponseData;
import com.dnk.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.dnk.dict.redis.RedisChannel.WEB_COMMAND_RESPONSE;

@Service
public final class WebMessageListener extends AbstractRedisListener {

    private static final Logger logger = LoggerFactory.getLogger(WebMessageListener.class);

    @Resource
    private RequestService requestService;

    WebMessageListener() {
        super(WEB_COMMAND_RESPONSE);
    }

    @Override
    void handleMessage(RedisChannel redisChannel, byte[] content) {
        WebCommandResponseData data = JSON.parseObject(content, WEB_COMMAND_RESPONSE.getClazz());
        String serverId = data.getWebServerId();
        //TODO:equals
        logger.info("serverId:{}", serverId);

        String id = data.getId();//request-sn

        requestService.updateOnFinish(id, data.isResult());

    }
}
