package com.dnk.dict.redis.channel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public final class GatewayVersionRequestData {
    @NonNull
    private String sn;
}
