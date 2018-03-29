package com.example.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Reason: 权限校验测试 date: 2018年1月19日 上午10:59:27 <br/>
 * 
 * @author Wangch
 * @junit {@link ShiroAccessPermissionControllerTest}
 */
@Controller
@RequestMapping(value = {"/permission"})
public class ShiroAccessPermissionController {

    public static final Logger log = LoggerFactory.getLogger(ShiroAccessPermissionController.class);


    /** 日志输出对象 **/
    public static final Log logout = LogFactory.getLog(ShiroAccessPermissionController.class);

    /**
     * 测试访问
     */
    @RequestMapping(value = {"/org_add"}, method = RequestMethod.GET)
    @RequiresPermissions(value = {"org:add"})
    @ResponseBody
    public String org_add() {

        return "add success";
    }

    @RequestMapping(value = {"/org_update"}, method = RequestMethod.GET)
    @RequiresPermissions(value = {"org:update"})
    @ResponseBody
    public String org_update() {
        Subject subject = SecurityUtils.getSubject();
        log.info("是否登陆：" + subject.isAuthenticated());

        return "update success";
    }

    @RequestMapping(value = {"/org_delete"}, method = RequestMethod.GET)
    @RequiresPermissions(value = {"org:delete"})
    @ResponseBody
    public String org_delete() {

        return "delete success";
    }

    @RequestMapping(value = {"/org_list"}, method = RequestMethod.GET)
    @RequiresPermissions(value = {"org:list"})
    @ResponseBody
    public String org_list() {

        return "list success";
    }
}
