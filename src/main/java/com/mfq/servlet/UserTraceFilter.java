package com.mfq.servlet;

import com.mfq.bean.Users;
import com.mfq.constants.Constants;
import com.mfq.constants.ErrorCodes;
import com.mfq.dataservice.context.AppContext;
import com.mfq.dataservice.context.UserIdHolder;
import com.mfq.utils.*;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserTraceFilter implements Filter {

    private static final UserTraceLogger userTrace = UserTraceLogger
            .getLogger(UserTraceFilter.class);

    /**
     * 拦截需要做
     * 1,是否有session记录,有的话像UserHolder加入userId(为了@LoginRequired注释)
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
     

        AppContext.setIp(getIp(req));
        boolean needLog = isNeedLog(req);
        AppContext.setUserTrace(needLog);

        HttpSession session = req.getSession();
        Users user = session.getAttribute("user")!=null?(Users)session.getAttribute("user"):null;
        if(user != null ){
            if(user.getUid()!=0){
                UserIdHolder.setUserId(user.getUid());
            }else{
                session.setAttribute("user",null);
                RequestUtils.writeResponse(req, resp,
                        JsonUtil.toJson(ErrorCodes.CORE_NEED_LOGIN, "登陆账号出错", null));
                return;
            }
        }
//        if(needLog){ // 如果是需要微信环境下请求的资源,也就是 css,js等 除外
//            String openId = getOpenId(req);
//            if(openId == null){
//                RequestUtils.writeResponse(req, resp,
//                        JsonUtil.toJson(ErrorCodes.WECHAT_REQUIRED, "请在微信环境下打开网页", null));
//                return;
//            }
//
//        }


        try {
            chain.doFilter(request, response);
        } catch (IOException e) {
            logError(e);
            throw e;
        } catch (ServletException e) {
            logError(e);
            throw e;
        } catch (RuntimeException e) {
            logError(e);
            throw e;
        } finally {

        }

    }




    private String getIp(HttpServletRequest req) {
        String ip = req.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip)
                || StringUtils.equalsIgnoreCase("unknown", ip)) {
            ip = req.getRemoteAddr();
        }
        if (StringUtils.equalsIgnoreCase("127.0.0.1", ip)) {
            ip = DnsUtil.getHostAddress();
        }
        if (StringUtils.length(ip) > 15 && StringUtils.indexOf(ip, ",") > 0) {
            ip = StringUtils.substring(ip, 0, StringUtils.indexOf(ip, ","));
        }
        return ip;
    }

    private boolean isNeedLog(HttpServletRequest req) {
        String uri = req.getRequestURI();

        if (uri.endsWith(".jsp") || uri.endsWith(".css") || uri.endsWith(".js")
                || uri.endsWith(".jpg") || uri.endsWith(".png")
                || uri.startsWith("/version") || uri.startsWith("/favicon.ico")
                || uri.startsWith("/healthcheck.html")) {
            return false;
        }

        return true;
    }

    private void logError(Exception e) {
        userTrace.error("Request Error", e);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}