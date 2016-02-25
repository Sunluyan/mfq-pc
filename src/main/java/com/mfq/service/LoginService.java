package com.mfq.service;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mfq.bean.Installation;
import com.mfq.bean.passport.Passport;
import com.mfq.bean.user.User;
import com.mfq.constants.Constants;
import com.mfq.constants.ErrorCodes;
import com.mfq.dataservice.context.AppContext;
import com.mfq.helper.MobileHelper;
import com.mfq.net.tongdun.FraudApiInvoker;
import com.mfq.service.passport.PassportService;
import com.mfq.service.user.UserService;
import com.mfq.utils.CookieUtils;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.MD5Util;
import com.mfq.utils.VerifyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    private static final Logger log = LoggerFactory
            .getLogger(LoginService.class);

    @Resource
    UserService userService;
    @Resource
    PassportService passportService;
    @Resource
    MsInstallationService msInstallationService;
    @Resource
    FraudApiInvoker fraudApiInvoker;

    public User queryUser(String login) {
        log.info("queryUser by {}", login);
        if (StringUtils.isEmpty(login)) {
            return new User();
        }
        User user;
        // ?? 如果邮箱或手机号没激活, 允许登录吗？目前允许
        if (login.contains("@")) {
            user = userService.queryUserByEmail(login);
        } else if (login.matches("\\d+")) {
            user = userService.queryUserByMobile(login);
        } else {
            user = new User();
        }
        log.info("User detail at LoginService:{}",user.toString());
        return user;
    }

    public String login(HttpServletRequest request,
            HttpServletResponse response, String login, String password,
            String refer, boolean autologin,String blackbox) throws Exception {

        if (StringUtils.isBlank(password)) {
            return JsonUtil.toJson(ErrorCodes.USER_WRONG_PASS, "密码错误", null);
        }
        User user = queryUser(login);

        Map<String, ?> dataMap = Maps.newHashMap();
        Passport passport;
        if (user.getUid() > 0) {
            passport = passportService.queryPassport(user.getUid());
            if (passport.getUid() > 0) {
                dataMap = _saltMap(passport);
            }
        }
        if (CollectionUtils.isEmpty(dataMap)) {
            return JsonUtil.toJson(ErrorCodes.USER_NOT_FIND, "账号不存在", null);
        }
        String salt = (String) dataMap.get("salt");
        String salt2 = (String) dataMap.get("salt2");

        // 登陆
        String password2 = MD5Util
                .md5Digest(MD5Util.md5Digest(password + salt) + salt2);
        passport = passportService.login(user.getUid(), password2,
                    autologin);
        
        //////////////插入同盾验证
        String ip_address = AppContext.getIp();
        String mobileType = MobileHelper.getMobileType(request);
        //////////////
        if (passport.getUid() == 0) {
        	if(StringUtils.isNotEmpty(blackbox))fraudApiInvoker.fraudLogin(ip_address, login, 1, blackbox, mobileType);
        	return JsonUtil.toJson(ErrorCodes.USER_WRONG_PASS, "密码错误", null);
        } else {
        	Map<String,Object> result = new HashMap<String, Object>();
        	if(StringUtils.isNotEmpty(blackbox))result = fraudApiInvoker.fraudLogin(ip_address, login, 0, blackbox, mobileType);
        	log.info("fraudLogin as result Params :{}",result);
    		//如果result不为空且裁决是拒绝时
        	if(result != null && result.size()>0 && result.get("decision").toString().toLowerCase().equals("reject") ){
        		log.info("result.msg{}",result.get("msg"));
        		return JsonUtil.toJson(ErrorCodes.FRAUD_ERROR, result.get("msg").toString(), null);
        	}else{
        		return _handleLogin(user, passport, autologin, refer, request,response);        		
        	}
        }
    }


    public User login4web(String username,String password,String tokenId) throws Exception{
        if (StringUtils.isBlank(password)) {
            throw new Exception("密码不能为空");
        }
        else if(VerifyUtils.verifyPassword(password)){
            throw new Exception("密码格式错误");
        }
        else if(VerifyUtils.verifyMobile(username)){
            throw new Exception("手机号格式错误");
        }
        User user = queryUser(username);

        Map<String, ?> dataMap = Maps.newHashMap();
        Passport passport;
        if (user.getUid() > 0) {
            passport = passportService.queryPassport(user.getUid());
            if (passport.getUid() > 0) {
                dataMap = _saltMap(passport);
            }
        }else{
            throw new Exception("账号不存在");
        }
        if (CollectionUtils.isEmpty(dataMap)) {
            throw new Exception("密码验证有误");
        }

        String salt = (String) dataMap.get("salt");
        String salt2 = (String) dataMap.get("salt2");
        // 登陆
        String password2 = MD5Util
                .md5Digest(MD5Util.md5Digest(password + salt) + salt2);
        passport = passportService.login(user.getUid(), password2,
                true);

        //插入同盾验证
        String ip_address = AppContext.getIp();
        String mobileType = "web";
        if (passport.getUid() == 0) {
            if(StringUtils.isNotEmpty(tokenId))fraudApiInvoker.fraudLogin(ip_address, username, 1, tokenId, mobileType);
            log.error("密码错误");
            throw new Exception("密码错误");
        } else {
            Map<String,Object> result = new HashMap<>();
            if(StringUtils.isNotEmpty(tokenId))result = fraudApiInvoker.fraudLogin(ip_address, username, 0, tokenId, mobileType);
            log.info("fraudLogin as result Params :{}",result);
            //如果result不为空且裁决是拒绝时
            if(result != null && result.size()>0 && result.get("decision").toString().toLowerCase().equals("reject") ){
                log.error("result.msg{}",result.get("msg"));
                throw new Exception(result.get("msg").toString());
            }else{
                //return _handleLogin(user, passport, autologin, refer, request,response);

            }
        }
        return user;
    }



    public void logoutCancelCookies(HttpServletRequest request,
            HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response,
                CookieUtils.getCookie(request, CookieUtils.COOKIE_MM), null);
    }





    public void updateIntallations(HttpServletRequest request, long uid)
            throws Exception {
        // 更新推送列表的信息
        String deviceType = MobileHelper.getMobileType(request);
        String deviceToken = MobileHelper.getMobileUid(request);
        
        String appId = ServletRequestUtils.getStringParameter(request, "app_id",
                "");
        String appVersion = MobileHelper.getMobileVer(request);
        if (Constants.APP_TYPE.contains((deviceType))
                && StringUtils.isNotEmpty(deviceToken)
                && StringUtils.isNotEmpty(appId)
                && StringUtils.isNotEmpty(appVersion)) {
            // 更新ms_installations表的数据
            Installation installation = msInstallationService
                    .queryInstallationByDeviceTypeAndDeviceToken(deviceType,
                            deviceToken);
            boolean succeed = false;
            if (installation == null) {
                installation = new Installation();
                installation.setDeviceType(deviceType);
                installation.setDeviceToken(deviceToken);
                installation.setAppId(appId);
                installation.setAppVersion(appVersion);
                installation.setUid(uid);
                installation.setChannels(
                        JsonUtil.writeToJson(new ArrayList<String>()));
                installation.setBadge(0);
                msInstallationService.createInstallation(installation);
                succeed = true;
            } else {
                installation.setAppId(appId);
                installation.setAppVersion(appVersion);
                installation.setUid(uid);
                succeed = msInstallationService.updateInstallations(installation);
            }

            if (!succeed) {
                log.info(String.format("更新用户设备信息失败：%d, %s, %s, %s, %s", uid,
                        deviceType, deviceToken, appId, appVersion));
            } else {
                log.info(String.format("更新用户设备信息成功：%d, %s, %s, %s, %s", uid,
                        deviceType, deviceToken, appId, appVersion));
            }
        } else {
            log.info(String.format("更新用户设备信息忽略：%d, %s, %s, %s, %s", uid,
                    deviceType, deviceToken, appId, appVersion));
        }
    }

    private Map<String, ?> _saltMap(Passport passport) {
        if (StringUtils.isEmpty(passport.getSalt())
                || StringUtils.isEmpty(passport.getSalt2())) {
            return Collections.emptyMap();
        }
        return ImmutableMap.of("salt", passport.getSalt(), "salt2",
                passport.getSalt2(), "time", System.currentTimeMillis());
    }

    private String _handleLogin(User user, Passport passport, boolean autologin,
            String refer, HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        if (user.getStatus() == com.mfq.bean.user.Status.DELETED) {
            // 用户已经被删除
            return JsonUtil.toJson(ErrorCodes.USER_NOT_FIND, "帐号不存在",
                    ImmutableMap.of("error", "用户已被删除"));
        }
        if (user.getStatus() == com.mfq.bean.user.Status.INACTIVE) {
            // 用户未激活
            String forward_url = "http://m.5imfq.com/reg/mailform/?email="
                    + user.getEmail() + "&refer=" + refer;
            return JsonUtil.toJson(ErrorCodes.USER_NOT_ACTIVE, "用户未激活",
                    ImmutableMap.of("forward_url", forward_url));
        }
        Map<String, Object> data = Maps.newHashMap();
        data.put("forward_url", refer);
        userService.updateUsersLogin(passport.getUid(),
                request.getRemoteAddr());
        
        CookieUtils.setLoginCookie(request, response, passport, autologin);

        // 送上积分
        // reputationService.createReputationLog(user.getUid(), Action.LOGIN,
        // ReputationExtraUtils.getBasicActionExtra(user.getUid(), "主动登录"));
        data.put("status", user.getStatus().getValue());
        data.put("token", passport.getTicket());
        data.put("uid", user.getUid());
        data.put("nick", user.getNick());
        data.put("avatar", user.getIcon());
        data.put("gender", user.getGender().getValue());
        
        return JsonUtil.successResultJson(data);
    }
}