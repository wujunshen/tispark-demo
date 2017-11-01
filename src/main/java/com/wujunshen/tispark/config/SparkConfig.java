package com.wujunshen.tispark.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.TiContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: frankwoo(吴峻申) <br>
 * @date: 2017/10/25 <br>
 * @time: 下午10:56 <br>
 * @mail: frank_wjs@hotmail.com <br>
 */
@Configuration
@Slf4j
public class SparkConfig {
    @Resource
    private SparkProperties sparkProperties;

    @Bean
    public TiContext getTiContext() {
        log.info("\nApplicationName is:{}\nmaster uri is:{}\nspark.tispark.pd.addresses is:{}\n",
                sparkProperties.getApplicationName(),
                sparkProperties.getMasterURI(),
                sparkProperties.getPdAddress());

        SparkSession sparkSession = SparkSession
                .builder()
                .config("spark.port.maxRetries", "10000000")
                .config("spark.testing.memory", "2147480000")
                .config("spark.tispark.pd.addresses", sparkProperties.getPdAddress())
                .master(sparkProperties.getMasterURI())
                .appName(sparkProperties.getApplicationName())
                .getOrCreate();

        TiContext tiContext = new TiContext(sparkSession);
        tiContext.tidbMapDatabase("TPCH_001", false);

        return tiContext;
    }
}