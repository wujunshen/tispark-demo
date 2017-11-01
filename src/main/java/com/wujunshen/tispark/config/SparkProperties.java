package com.wujunshen.tispark.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: frankwoo(吴峻申) <br>
 * @date: 2017/10/26 <br>
 * @time: 下午12:17 <br>
 * @mail: frank_wjs@hotmail.com <br>
 */
@Data
@ConfigurationProperties(prefix = "spark")
@Component
public class SparkProperties {
    private String applicationName;
    private String masterURI;
    private String pdAddress;
}