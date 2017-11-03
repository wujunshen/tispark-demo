package com.wujunshen.tispark.controller;

import com.wujunshen.tispark.TisparkDemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: frankwoo(吴峻申) <br>
 * @date: 2017/11/3 <br>
 * @time: 下午12:31 <br>
 * @mail: frank_wjs@hotmail.com <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TisparkDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles(profiles = "test")
public class DemoControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTiSpark() throws Exception {
        String actual = template.getForObject("/", String.class);

        assertThat(actual, equalTo("success"));
    }
}