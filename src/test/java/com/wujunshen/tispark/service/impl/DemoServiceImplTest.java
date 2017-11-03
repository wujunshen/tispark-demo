package com.wujunshen.tispark.service.impl;

import com.wujunshen.tispark.TisparkDemoApplication;
import com.wujunshen.tispark.service.DemoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: frankwoo(吴峻申) <br>
 * @date: 2017/11/3 <br>
 * @time: 下午4:51 <br>
 * @mail: frank_wjs@hotmail.com <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TisparkDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles(profiles = "test")
public class DemoServiceImplTest {
    @Resource
    private DemoService demoService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTiSpark() throws Exception {
        demoService.testTiSpark();
    }
}