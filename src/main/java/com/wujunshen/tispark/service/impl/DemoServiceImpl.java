package com.wujunshen.tispark.service.impl;

import com.wujunshen.tispark.service.DemoService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.TiContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public void testTiSpark() {
        Dataset dataset = tiContext.session().sql("select * from customer");
        dataset.show();
        tiContext.session().stop();
    }
}