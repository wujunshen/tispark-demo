package com.wujunshen.tispark;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TisparkDemoApplication {

    public static void main(String[] args) {
        log.info("start execute TisparkDemoApplication....\n");
        SpringApplication.run(TisparkDemoApplication.class, args);
        log.info("end execute TisparkDemoApplication....\n");
    }
}