package com.dnk.service;

import com.dnk.entity.Lock;

public interface LockService {

    Lock getById(long id);

    Lock getByUuid(String uuid);

    String getGatewaySnByUuid(String uuid);

}
