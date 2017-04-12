package com.dnk.repository;

import com.dnk.entity.Gateway;

public interface GatewayRepository {

    Gateway getById(long id);

    Gateway getBySn(String sn);

    Gateway getByUdid(String udid);
}
