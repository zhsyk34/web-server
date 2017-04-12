package com.dnk.service.impl;

import com.dnk.entity.Gateway;
import com.dnk.entity.Lock;
import com.dnk.repository.GatewayRepository;
import com.dnk.repository.LockRepository;
import com.dnk.service.LockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LockServiceImpl implements LockService {
    @Resource
    private LockRepository lockRepository;
    @Resource
    private GatewayRepository gatewayRepository;

    @Override
    public Lock getById(long id) {
        return lockRepository.getById(id);
    }

    @Override
    public Lock getByUuid(String uuid) {
        return lockRepository.getByUuid(uuid);
    }

    @Override
    public String getGatewaySnByUuid(String uuid) {
        Lock lock = this.getByUuid(uuid);
        if (lock == null) {
            return null;
        }

        return Optional.ofNullable(gatewayRepository.getById(lock.getGatewayId())).map(Gateway::getSn).orElse(null);
    }
}
