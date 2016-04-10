package com.mfq.controller;

import com.mfq.bean.user.User;
import com.mfq.constants.ErrorCodes;
import com.mfq.dataservice.context.AppContext;
import com.mfq.helper.MobileHelper;
import com.mfq.helper.SignHelper;
import com.mfq.service.LoginService;
import com.mfq.service.RegisterService;
import com.mfq.service.user.UserService;
import com.mfq.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.ocsp.Req;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    
    @Resource
    LoginService loginService;
    @Resource
    RegisterService registerService;
    @Resource
    UserService userService;


    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/web/register", "/web/register/"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String register4web(HttpServletRequest request, HttpServletResponse response) {
        try{

            String asid = AppContext.getIp();
            String mobile =  request.getParameter("mobile");
            String nick =  request.getParameter("nick");
            String password =  request.getParameter("password");
            String vcode =  request.getParameter("vcode");
            String invite_code = StringUtils.stripToEmpty(request.getParameter("p_code"));
            String token_id = request.getParameter("token_id") == null ? null :request.getParameter("token_id").toString();
            int career = request.getParameter("role") == null? 0 : Integer.parseInt(request.getParameter("role"));
            String type = "web";

            //如果出问题,会抛出错误
            long uid = registerService.reg("", mobile, nick, password,
                    vcode, request.getRemoteAddr(), "", "", "asid:" + asid,
                    career, invite_code,token_id,type,request,response);
            User user = userService.queryUser(uid);

            HttpSession session = request.getSession();

            session.setAttribute("user",user);
            session.setMaxInactiveInterval(60*60*24*15);

            return JsonUtil.successResultJson(user);
        }catch(Exception e){
            logger.error("Exception_Register_Progress!", e);
            return JsonUtil.toJson(ErrorCodes.CORE_ERROR, e.getMessage(), null);
        }
    }


    @RequestMapping(value = {"/logout","/logout/"},method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return JsonUtil.successResultJson();
        } catch (Exception e) {
            logger.error("Exception_Register_Progress!", e);
            return JsonUtil.toJson(ErrorCodes.CORE_ERROR, e.toString(), null);
        }
    }

    public static void main(String[] args) {

    }


}