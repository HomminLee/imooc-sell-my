package com.hommin.study.imoocsell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Hommin
 * @ClassName: LogbackTest
 * @Description:
 * @data 2018年04月05日 下午10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogbackTest {

    private Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test(){
        String name = "hommin";
        String password = "123456";
        logger.info("info....");
        logger.error("error....");
        logger.debug("debug....");
        logger.info("name: {}, password: {}", name, password);
    }
}


