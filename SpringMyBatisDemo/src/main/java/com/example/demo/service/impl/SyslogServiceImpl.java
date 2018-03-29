package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Syslog;
import com.example.demo.dao.SyslogDao;
import com.example.demo.service.SyslogService;
import com.github.pagehelper.PageRowBounds;

@Service
public class SyslogServiceImpl implements SyslogService {
    @Resource
    private SyslogDao dao;

    @Override
    public List<Syslog> querySyslog() {
        return this.dao.querySyslog();
    }

    @Override

    public List<Syslog> querySyslogByPage(PageRowBounds prb) {

        return this.dao.querySyslogByPage(prb);
    }

    @Override
    @Transactional
    public void saveSyslog(List<Syslog> syslogs) {
        syslogs.forEach(this.dao::saveSyslog);
    }

}
