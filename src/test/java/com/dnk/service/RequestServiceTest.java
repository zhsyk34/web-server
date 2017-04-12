package com.dnk.service;

import com.dnk.dict.RequestStatusEnum;
import com.dnk.init.Init;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestServiceTest extends Init {

    @Autowired
    private RequestService requestService;

    private String sn = "893cd587-d4c3-4063-a50f-6b9ea19bb30f";

    @Test
    public void updateByStatus() throws Exception {
        requestService.updateByStatus(sn, RequestStatusEnum.SUCCESS);
    }

    @Test
    public void updateOnSubmit() throws Exception {
        requestService.updateByStatus(sn, RequestStatusEnum.FAIL);
    }

    @Test
    public void updateOnFinish() throws Exception {

    }

    @Test
    public void updateOnCallback() throws Exception {
        requestService.updateByStatus(sn, RequestStatusEnum.FINISH);
    }

}