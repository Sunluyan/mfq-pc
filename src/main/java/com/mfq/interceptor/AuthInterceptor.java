package com.mfq.interceptor;

import com.mfq.annotation.LoginRequired;
import com.mfq.annotation.WechatRequired;
import com.mfq.bean.wechat.OpenId;
import com.mfq.constants.Constants;
import com.mfq.constants.ErrorCodes;
import com.mfq.dataservice.context.UserIdHolder;
import com.mfq.service.UserService;
import com.mfq.utils.Config;
import com.mfq.utils.HttpUtil;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.RequestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Spring 认证拦截器
 * Created by xingyongshan on 15/8/4.
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter
        implements Ordered {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthInterceptor.class);

    @Resource
    UserService userService;

    public AuthInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 〇 非.5imfq.com域名 直接无视，系统错误。
        // 〇 如果是白名单地址（某些controller无需登录），直接通过，返回true
        // 〇 如果未登录且页面需要登录信息，则返回false
        // 〇 返回true
        String serverName = request.getServerName();
        logger.debug("requestServerName:{}", serverName);
//        String domainSuffix = Constants.COOKIE_DOMAIN;
//        if (!serverName.endsWith(domainSuffix)) {
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/plain; charset=UTF-8");
//            response.getWriter().append("域名错误(必须*" + domainSuffix + ")");
//            return false;
//        }

        HttpSession session = request.getSession();

        String code = request.getParameter("code");
        logger.debug("code : " + code);
        if (session.getAttribute("openid") == null && StringUtils.isEmpty(code)) {
            logger.debug("not have a openid");
//             response.sendRedirect("/wechat/notwechat");// TODO
            if (Config.isDev()) {
                session.setAttribute("openid", "ot7eHxIp5Ch33prnfcYlvqOuFTCE");
                session.setAttribute("uid", 9529);
            }
        }
        logger.debug("openid"+session.getAttribute("openid"));
        if (session.getAttribute("openid") == null && !StringUtils.isEmpty(code)) {
            String re = HttpUtil.postJson("https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
                            .replace("APPID", Constants.APPID)
                            .replace("SECRET", Constants.APPSECRET)
                            .replace("CODE", code),
                    "", false);
            logger.debug(code + "\t" + re);

            if (re.contains("openid")) {
                OpenId openId = JsonUtil.toBean(re, OpenId.class);
                try {
                    userService.selectOrInsertByOpenid(openId, session);
                } catch (Exception e) {
                    logger.error(e.getCause().toString());
                    e.printStackTrace();
                }

                session.setAttribute("openid", openId.getOpenid());
            }
        }


        return true;
    }


    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

    }


    /**
     * 检查登录需求
     *
     * @param request
     * @param response
     * @param handler
     * @return true表示OK，false表示登录失败，已经跳转到登录页面或者ajax结果
     * @throws Exception
     */
    private boolean checkLoginRequired(HttpServletRequest request,
                                       HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof org.springframework.web.servlet.resource.ResourceHttpRequestHandler) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequired loginRequired = handlerMethod
                .getMethodAnnotation(LoginRequired.class);
        if (loginRequired == null) {
            loginRequired = handlerMethod.getBeanType()
                    .getAnnotation(LoginRequired.class);
        }
        if (loginRequired != null && !UserIdHolder.isLogin()) {
            // 需要登录 但 未登录!!!!!
//            RequestUtils.writeResponse(request, response,
//                    JsonUtil.toJson(ErrorCodes.CORE_NEED_LOGIN, "需要登录", null));
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }

        return true;
    }

    /**
     * 检查环境
     *
     * @param request
     * @param response
     * @param handler
     * @return true表示OK，false表示登录失败，已经跳转到登录页面或者ajax结果
     * @throws Exception
     */
    private boolean checkWechat(HttpServletRequest request,
                                HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof org.springframework.web.servlet.resource.ResourceHttpRequestHandler) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        WechatRequired WechatRequired = handlerMethod
                .getMethodAnnotation(WechatRequired.class);
        if (WechatRequired == null) {
            WechatRequired = handlerMethod.getBeanType()
                    .getAnnotation(WechatRequired.class);
        }
        if (WechatRequired != null && getOpenId(request) == null) {
            // 需要微信环境但没有 openid .
            RequestUtils.writeResponse(request, response,
                    JsonUtil.toJson(ErrorCodes.WECHAT_REQUIRED, "请在微信浏览器内打开", null));
            return false;
        }
        return true;
    }

    /**
     * 获取每次连接是否有 openid ,如果没有的话,返回null.
     * 目前这里需要修改.
     *
     * @param request
     * @return
     */
    private String getOpenId(HttpServletRequest request) {
        String openId = request.getAttribute("openid") != null ? request.getAttribute("openid").toString() : null;
        HttpSession session = request.getSession();
        if (openId != null) {
            session.setAttribute("openid", openId);
            return openId;
        }
        openId = request.getParameter("openid") != null ? request.getParameter("openid").toString() : null;
        if (openId != null) {
            session.setAttribute("openid", openId);
            return openId;
        }
        return null;
    }


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
