package com.dnk.repository;

import com.dnk.entity.Lock;

public interface LockRepository extends AutoResolver{

    int save(Lock lock);

    Lock find(long id);
}
