package com.dnk.dict.redis.channel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public final class GatewayUdpPortAllocateData {
    @NonNull
    private String sn;
    private int allocated;
}
