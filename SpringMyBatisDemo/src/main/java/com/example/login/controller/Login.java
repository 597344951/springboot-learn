package com.example.login.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.shiro.authc.MyToken;

@Controller
@RequestMapping(value = {"/"})
public class Login {

    /** 日志输出对象 **/
    public static final Logger logout = LoggerFactory.getLogger(Login.class);


    public static final String LOGIN_URL = "/login/login";

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login_get(String un, String ps, Model model) {

        return "redirect:" + LOGIN_URL + ".jsp";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(String un, String ps, String tks, Model model) {
        try {
            Assert.notNull(un, "用户名不能为空");
            Assert.notNull(ps == null ? tks : ps, "密码或token值不能为空!");
            UsernamePasswordToken token = new UsernamePasswordToken(un, ps);
            SecurityUtils.getSubject().login(token);
        } catch (IncorrectCredentialsException ie) {
            // 验证不通过
            model.addAttribute("error", "用户名/密码不正确!");
            return LOGIN_URL;
        } catch (ExcessiveAttemptsException ee) {
            // 重试次数过多
            model.addAttribute("error", "登陆失败次数过多,请稍后重试!");
            return LOGIN_URL;
        } catch (AuthenticationException ae) {
            // 验证不通过
            model.addAttribute("error", "用户名/密码不正确!");
            return LOGIN_URL;
        } catch (Exception e) {
            logout.error(e.getMessage());
            model.addAttribute("error", "未知错误");
            return LOGIN_URL;
        }
        return "redirect:/";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(String un, String ps) {
        SecurityUtils.getSubject().logout();
        return "redirect:" + LOGIN_URL + ".jsp";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/view/index.jsp";
    }
}
