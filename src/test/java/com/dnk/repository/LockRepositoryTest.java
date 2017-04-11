package com.dnk.repository;

import com.dnk.entity.Lock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LockRepositoryTest {

    @Autowired
    private LockRepository lockRepository;

    @Test
    public void save() throws Exception {
        Lock lock = new Lock().setName("lock2");
        lockRepository.save(lock);
        System.out.println(lock.getId());
    }

    @Test
    public void find() throws Exception {
        Lock lock = lockRepository.find(2L);
        System.out.println(lock);
    }
}