package com.dnk.init;

import com.dnk.dict.ServerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Init {

    @Autowired
    private ServerConfig serverConfig;

    @Test
    public void testConfig() throws Exception {
        System.out.println(serverConfig.getServerId());
    }
}
