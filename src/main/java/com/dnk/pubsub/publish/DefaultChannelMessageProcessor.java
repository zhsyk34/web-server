package com.dnk.pubsub.publish;

import com.dnk.dict.redis.RedisChannel;
import com.dnk.dict.redis.channel.WebCommandRequestData;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public final class DefaultChannelMessageProcessor extends SimpleRedisPublisher implements ChannelMessageProcessor {

    @Override
    public void publishWebCommandResult(@NonNull String tcpServerId, @NonNull String sn) {
        super.publish(RedisChannel.WEB_COMMAND_REQUEST, WebCommandRequestData.of(tcpServerId, sn));
    }
}
