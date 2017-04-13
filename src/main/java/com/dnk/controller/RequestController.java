package com.dnk.controller;

import com.dnk.dict.ServerConfig;
import com.dnk.dict.redis.cache.Command;
import com.dnk.dict.redis.cache.TcpSession;
import com.dnk.entity.Request;
import com.dnk.exception.ResultEnum;
import com.dnk.pubsub.cache.RedisCacheAccessor;
import com.dnk.pubsub.publish.ChannelMessageProcessor;
import com.dnk.service.LockService;
import com.dnk.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RequestController {
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
    @Resource
    private LockService lockService;
    @Resource
    private RequestService requestService;
    @Resource
    private ChannelMessageProcessor channelMessageProcessor;
    @Resource
    private RedisCacheAccessor redisCacheAccessor;
    @Resource
    private ServerConfig serverConfig;

    @PostMapping("action")
    public Result<String> accept(@RequestBody Request request) {
        String webServerId = serverConfig.getServerId();

        String sn = lockService.getGatewaySnByUuid(request.getUuid());
        if (!StringUtils.hasText(sn)) {
            return Result.from(ResultEnum.PARAM, null);
        }

        TcpSession tcpSession = redisCacheAccessor.getTcpSession(sn);
        String tcpServerId = Optional.ofNullable(tcpSession).map(TcpSession::getServerId).orElse(null);
        logger.info("tcp session server:{}", tcpServerId);

        String context = request.getContext();
        logger.info("------------accept command{}", context);
        String requestSn = requestService.saveOnAccept(request.getUuid(), context, request.getAppId(), request.getCallback());
        Assert.notNull(sn, "gateway-sn can't be null");

        //submit
        redisCacheAccessor.shareAppCommand(sn, Command.of(requestSn, webServerId, context, System.currentTimeMillis()));
        requestService.updateOnSubmit(requestSn);

        //notify
        channelMessageProcessor.publishWebCommandResult(tcpServerId, sn);
        return Result.success(requestSn);
    }

}
