package com.dnk.dict.redis.channel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public final class GatewayVersionResponseData {
    @NonNull
    private String sn;
    @NonNull
    private String result;
}
