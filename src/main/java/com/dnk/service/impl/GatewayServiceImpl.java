package com.dnk.service.impl;

import com.dnk.entity.Gateway;
import com.dnk.repository.GatewayRepository;
import com.dnk.service.GatewayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GatewayServiceImpl implements GatewayService {
    @Resource
    private GatewayRepository gatewayRepository;

    @Override
    public Gateway getById(long id) {
        return gatewayRepository.getById(id);
    }

    @Override
    public Gateway getBySn(String sn) {
        return gatewayRepository.getBySn(sn);
    }

    @Override
    public Gateway getByUdid(String udid) {
        return gatewayRepository.getByUdid(udid);
    }
}
