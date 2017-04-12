package com.dnk.pubsub.subscribe;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.Topic;

import java.util.Collection;

public interface RedisListener {

    Collection<Topic> topics();

    MessageListener listener();
}
