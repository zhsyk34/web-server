package com.dnk.repository;

import com.dnk.entity.Lock;
import com.dnk.init.Init;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LockRepositoryTest extends Init {

    @Autowired
    private LockRepository lockRepository;

    @Test
    public void save() throws Exception {
//        Lock lock = new Lock().setName("lock2");
//        lockRepository.save(lock);
//        System.out.println(lock.getId());
    }

    @Test
    public void getById() throws Exception {
        Lock lock = lockRepository.getById(2L);
        System.out.println(lock);
    }
}