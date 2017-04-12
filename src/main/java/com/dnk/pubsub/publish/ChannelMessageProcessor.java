package com.dnk.pubsub.publish;

import lombok.NonNull;

public interface ChannelMessageProcessor {

    /**
     * web请求指令处理
     *
     * @param tcpServerId tcpServer 的编号
     * @param sn          gateway-sn
     */
    void publishWebCommandResult(@NonNull String tcpServerId, @NonNull String sn);
}
