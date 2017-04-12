package com.dnk.service;

import com.dnk.dict.RequestStatusEnum;
import com.dnk.entity.Request;

public interface RequestService {

    Request getById(long id);

    Request getBySn(String sn);

    String saveOnAccept(String uuid, String action, String params, String appId, String callback);

    int updateByStatus(String sn, RequestStatusEnum requestStatusEnum);

    int updateOnSubmit(String sn);

    int updateOnFinish(String sn, boolean result);

    int updateOnCallback(String sn);
}
