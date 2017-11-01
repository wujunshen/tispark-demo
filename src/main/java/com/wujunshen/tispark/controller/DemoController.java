package com.wujunshen.tispark.controller;

import com.wujunshen.tispark.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: frankwoo(吴峻申) <br>
 * @date: 2017/10/30 <br>
 * @time: 下午3:08 <br>
 * @mail: frank_wjs@hotmail.com <br>
 */
@RestController
@Slf4j
public class DemoController {
    @Resource
    private DemoService demoService;

    @GetMapping(value = "/")
    public void testTiSpark() {
        log.info("start testTiSpark........");
        demoService.testTiSpark();
        log.info("stop testTiSpark........");
    }
}