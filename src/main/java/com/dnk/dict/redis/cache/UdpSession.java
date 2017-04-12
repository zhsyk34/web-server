package com.dnk.dict.redis.cache;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public final class UdpSession {
    @NonNull
    private String serverId;
    @NonNull
    private String sn;
    @NonNull
    private String ip;
    private int port;
    private String version;
    private long happen;
}
