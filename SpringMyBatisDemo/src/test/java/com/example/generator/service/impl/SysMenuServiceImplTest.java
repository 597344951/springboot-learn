package com.example.generator.service.impl;


import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.common.util.SnowflakeIdWorker;
import com.example.generator.bean.SysMenu;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysMenuServiceImplTest {
    
    public static final Logger log = LoggerFactory.getLogger(SysMenuServiceImplTest.class);

    @Resource
    private SysMenuServiceImpl service;
    

    private SysMenuServiceImpl createTestSubject() {
        return this.service;
    }

    
    public void testInsertSelective() throws Exception {
        SysMenuServiceImpl testSubject;
        SnowflakeIdWorker flakeId = new SnowflakeIdWorker(0, 0);
        SysMenu record = new SysMenu();
        record.setMenuId(flakeId.nextId());
        record.setName("测试菜单");
        int result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.insertSelective(record);
        log.info("插入自增主键："+record.getMenuId());
    }


    public void testDeleteByPrimaryKey() throws Exception {
        SysMenuServiceImpl testSubject;
        Long menuId = null;
        int result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.deleteByPrimaryKey(menuId);
    }


    public void testInsert() throws Exception {
        SysMenuServiceImpl testSubject;
        SysMenu record = null;
        int result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.insert(record);
    }



    public void testSelectByPrimaryKey() throws Exception {
        SysMenuServiceImpl testSubject;
        Long menuId = null;
        SysMenu result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.selectByPrimaryKey(menuId);
    }


    public void testUpdateByPrimaryKeySelective() throws Exception {
        SysMenuServiceImpl testSubject;
        SysMenu record = null;
        int result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.updateByPrimaryKeySelective(record);
    }


    public void testUpdateByPrimaryKey() throws Exception {
        SysMenuServiceImpl testSubject;
        SysMenu record = null;
        int result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.updateByPrimaryKey(record);
    }
}
