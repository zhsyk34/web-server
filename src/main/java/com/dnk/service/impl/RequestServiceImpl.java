package com.dnk.service.impl;

import com.dnk.dict.RequestStatusEnum;
import com.dnk.entity.Request;
import com.dnk.repository.RequestRepository;
import com.dnk.service.RequestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.dnk.dict.RequestStatusEnum.*;

@Service
public class RequestServiceImpl implements RequestService {
    @Resource
    private RequestRepository requestRepository;

    @Override
    public Request getById(long id) {
        return requestRepository.getById(id);
    }

    @Override
    public Request getBySn(String sn) {
        return requestRepository.getBySn(sn);
    }

    @Override
    public String saveOnAccept(String uuid, String context, String appId, String callback) {
        Request request = new Request().setUuid(uuid).setContext(context).setAppId(appId).setCallback(callback);

        String sn = UUID.randomUUID().toString();//TODO:serverId
        request.setSn(sn).setAcceptTime(LocalDateTime.now()).setStatus(ACCEPT);
        return requestRepository.save(request) == 1 ? sn : null;
    }

    @Override
    public int updateByStatus(String sn, RequestStatusEnum requestStatusEnum) {
        Request request = requestRepository.getBySn(sn);
        if (request == null) {
            return 0;
        }
        request.setStatus(requestStatusEnum);
        switch (requestStatusEnum) {
            case SUBMIT:
                break;
            case SUCCESS:
            case FAIL:
                request.setFinishTime(LocalDateTime.now());
                break;
            case FINISH:
                request.setCallbackTime(LocalDateTime.now());
                break;
            default:
                break;
        }
        return requestRepository.updateByStatus(request);
    }

    @Override
    public int updateOnSubmit(String sn) {
        return this.updateByStatus(sn, SUBMIT);
    }

    @Override
    public int updateOnFinish(String sn, boolean result) {
        return this.updateByStatus(sn, result ? SUCCESS : FAIL);
    }

    @Override
    public int updateOnCallback(String sn) {
        return this.updateByStatus(sn, FINISH);
    }

}
