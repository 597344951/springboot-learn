package com.common.util;



import java.util.stream.IntStream;

import javax.annotation.Generated;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "org.junit-tools-1.0.6")
public class SnowflakeIdWorkerTest {

    /** 日志输出对象 **/
    public static final Logger logger = LoggerFactory.getLogger(SnowflakeIdWorkerTest.class);
 

    @Test
    public void testNextId() throws Exception {
        logger.info(Long.MAX_VALUE+"");
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            //System.out.println(Long.toBinaryString(id));
            logger.info(id+"");
        }
    }
}
