package com.example.redistest.service;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTestServiceTest {
    
    public static final Logger log = LoggerFactory.getLogger(RedisTestServiceTest.class);

    
    @Resource
    private RedisTestService service;

    private RedisTestService createTestSubject() {
        return this.service;
    }

    
    public void testSaveStr() throws Exception {
        RedisTestService testSubject;
        String key = "testkey1";
        String value = "testvalue";


        // default test
        testSubject = createTestSubject();
        testSubject.saveStr(key, value);
    }

    
    public void testReadStr() throws Exception {
        RedisTestService testSubject;
        String key = "testkey";
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.readStr(key);
        log.info(result);
    }
}
