package com.mfq.controller;

import com.mfq.bean.user.User;
import com.mfq.constants.Constants;
import com.mfq.constants.ErrorCodes;
import com.mfq.dataservice.context.UserIdHolder;
import com.mfq.helper.SignHelper;
import com.mfq.service.LoginService;
import com.mfq.service.passport.PassportService;
import com.mfq.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户管理&登陆退出相关-无线
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory
            .getLogger(LoginController.class);

    @Resource
    LoginService loginService;
    @Resource
    PassportService passportService;

    @RequestMapping(value = {"/web/login", "/web/login/"}, method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login4web(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("user") != null){
                return JsonUtil.toJson(ErrorCodes.CORE_ERROR,"您已经在登录状态",null);
            }

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = loginService.login4web(username, password);

            if(user != null){
                session.setAttribute("user",user);
                session.setMaxInactiveInterval(60*60*24*15);
                return JsonUtil.successResultJson(user);
            }

        } catch (Exception e) {
            logger.error("Exception Login Process!", e);
            return JsonUtil.toJson(ErrorCodes.CORE_ERROR, "系统异常", null);
        }
        return JsonUtil.toJson(ErrorCodes.CORE_ERROR, "系统异常", null);
    }



    @RequestMapping(value = {"/web/isLogin","/web/isLogin/"},produces = "application/json;charset=utf-8")
    public @ResponseBody String logout4web(HttpServletRequest request) {
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("user")!=null){
                return JsonUtil.successResultJson(session.getAttribute("user"));
            }
            return JsonUtil.toJson(9999,"未登录",null);
        } catch (Exception e) {
            logger.error("Exception Login Process!", e);
            return JsonUtil.toJson(ErrorCodes.CORE_ERROR, "系统异常", null);
        }
    }
}
