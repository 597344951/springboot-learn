package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Syslog;
import com.example.demo.service.SyslogService;
import com.github.pagehelper.PageRowBounds;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/syslog")
public class TestController {
    public static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private SyslogService syslogService;

    @ApiOperation(value = "查询日志", notes = "列出所有日志信息")
    @RequestMapping("/list1")
    public List<Syslog> listSyslog1() {

        return this.syslogService.querySyslog();
    }

    @ApiOperation(value = "查询日志", notes = "根据分页数据获取日志数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start", value = "开始条数", required = true, dataType = "Integer",paramType="query")})
    @RequestMapping("/list2")
    public List<Syslog> listSyslog2(Integer start) {
        PageRowBounds prb = new PageRowBounds(start, 20);
        List<Syslog> syslogs = this.syslogService.querySyslogByPage(prb);
        logger.info("分页查询:" + prb.getTotal());
        return syslogs;
    }

    @ApiOperation(value = "新增日志数据", notes = "新增日志数据")
    @RequestMapping("/add")
    public List<Syslog> addSyslog() {
        List<Syslog> syslogs = new ArrayList<>();
        Syslog syslog = new Syslog();
        syslog.setUsername("thisis");
        syslog.setOperation("add");
        syslog.setMethod("get");
        syslog.setParams("a=b&b=c");
        syslog.setIp("192.168.1.111");

        syslogs.add(syslog);

        syslog = new Syslog();
        syslog.setUsername(
                "thisisfffffffffasdsdsdsdsdasdafffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        syslog.setOperation("add");
        syslog.setMethod("get");
        syslog.setParams("a=b&b=c");
        syslog.setIp("192.168.1.111");
        syslogs.add(syslog);


        this.syslogService.saveSyslog(syslogs);
        return syslogs;
    }

}
