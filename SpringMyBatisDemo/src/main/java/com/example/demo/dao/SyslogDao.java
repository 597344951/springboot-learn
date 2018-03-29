package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Syslog;
import com.github.pagehelper.PageRowBounds;

public interface SyslogDao {
    public List<Syslog> querySyslog();

    public List<Syslog> querySyslogByPage(PageRowBounds prb);

    public void saveSyslog(Syslog syslog);
}
