package com.dnk.service;

import com.dnk.entity.Gateway;

public interface GatewayService {

    Gateway getById(long id);

    Gateway getBySn(String sn);

    Gateway getByUdid(String udid);
}
