package com.dnk.dict.redis.channel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public final class WebCommandResponseData {
    @NonNull
    private String webServerId;
    @NonNull
    private String id;
    //TODO:改进为enum int
    private boolean result;
}
