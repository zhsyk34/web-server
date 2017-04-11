package com.dnk.service;

import com.dnk.entity.Lock;
import com.dnk.repository.LockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockService {

    @Autowired
    private LockRepository lockRepository;

    public Lock find(long id) {
        return lockRepository.find(id);
    }
}
