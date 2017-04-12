package com.dnk.controller;

import com.dnk.pubsub.publish.ChannelMessageProcessor;
import com.dnk.service.LockService;
import com.dnk.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping("action")
    public Result<String> accept(String uuid, String action, String params, String appId, String callback) {
        logger.info("------------accept----------");
        String requestSn = requestService.saveOnAccept(uuid, action, params, appId, callback);
        String sn = lockService.getGatewaySnByUuid(uuid);
        logger.info("gateway sn:{}", sn);
        channelMessageProcessor.publishWebCommandResult("web001", sn);
        return Result.success(requestSn);
    }

}
