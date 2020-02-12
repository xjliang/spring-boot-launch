package com.xjliang.bootlaunch.yaml;

import com.xjliang.bootlaunch.service.TestBeanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportResourcesTest {

    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean exist = ioc.containsBean("testBeanService");
        System.out.println(exist);
    }
}
