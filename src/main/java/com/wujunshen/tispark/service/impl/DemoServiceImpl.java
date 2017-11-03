package com.wujunshen.tispark.service.impl;

import com.wujunshen.tispark.config.SparkProperties;
import com.wujunshen.tispark.service.DemoService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.TiContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author: frankwoo(吴峻申) <br>
 * @date: 2017/10/30 <br>
 * @time: 下午3:10 <br>
 * @mail: frank_wjs@hotmail.com <br>
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private TiContext tiContext;

    @Resource
    private SparkProperties sparkProperties;

    @Override
    public void testTiSpark() {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", sparkProperties.getUser());
        connectionProperties.put("password", sparkProperties.getPassword());

        Dataset<Row> dataset = tiContext.session().read().jdbc(sparkProperties.getUrl(), "CUSTOMER", connectionProperties);

        dataset.show();

        dataset.createOrReplaceTempView("CUSTOMER");
        Dataset dataset2 = dataset.sqlContext().sql("select count(*) from CUSTOMER");
        dataset2.show();

        //tiContext.tidbMapDatabase("TPCH_001", false);
        //Dataset dataset1 = tiContext.session().sql("select count(*) from CUSTOMER");
        //dataset1.show();

        //tiContext.session().stop();
    }
}