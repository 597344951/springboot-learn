package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Syslog;
import com.github.pagehelper.PageRowBounds;

public interface SyslogService {
    
    public List<Syslog> querySyslog();
    
    public List<Syslog> querySyslogByPage(PageRowBounds prb);

    public void saveSyslog(List<Syslog> syslogs);
    
}
