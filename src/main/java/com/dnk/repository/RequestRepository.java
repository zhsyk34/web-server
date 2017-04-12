package com.dnk.repository;

import com.dnk.entity.Request;

public interface RequestRepository {

    Request getById(long id);

    Request getBySn(String sn);

    int save(Request request);

    int updateByStatus(Request request);

}
