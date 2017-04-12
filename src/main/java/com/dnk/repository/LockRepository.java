package com.dnk.repository;

import com.dnk.entity.Lock;

public interface LockRepository {

    Lock getById(long id);

    Lock getByUuid(String uuid);

}
