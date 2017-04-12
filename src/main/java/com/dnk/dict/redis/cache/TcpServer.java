package com.dnk.dict.redis.cache;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public final class TcpServer {
    @NonNull
    private String serverId;
    private long happen;
}
