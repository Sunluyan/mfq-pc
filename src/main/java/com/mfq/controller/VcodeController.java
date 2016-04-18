package com.mfq.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mfq.service.sms.SMSService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.mfq.bean.CodeMsg;
import com.mfq.bean.Vcode;
import com.mfq.constants.ErrorCodes;
import com.mfq.helper.SignHelper;
import com.mfq.service.VcodeService;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.RequestUtils;

/**
 * 手机确认码服务
 */
@Controller
public class VcodeController {

    private static final Logger logger = LoggerFactory
            .getLogger(VcodeController.class);

    private final long MOBILE_EXPIRE_DURATION = 1000 * 60 * 30; // 30分钟有效
    private final long Msm_SEND_DURATION = 1000 * 60 * 2; // 重发时间2分钟
    private final int MAX_TIMES_PRE_IP = 1000;

    @Resource
    VcodeService vcodeService;
    @Resource
    SMSService smsService;

    /**
     * 发送短信确认码
     *
     * @param request
     *            请求
     * @param response
     *            响应
     * @throws Exception
     *             任何异常
     */
    @RequestMapping(value = {"/vcode/send", "/vcode/send/"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String apply(HttpServletRequest request,
            HttpServletResponse response) {
        try{
            String mobile =  request.getParameter("mobile");
            String ip = RequestUtils.getString(request, "ip",
                    request.getRemoteAddr());

            Date expireAt = new Date(System.currentTimeMillis() + MOBILE_EXPIRE_DURATION);
            Date resendAt = new Date(System.currentTimeMillis() + Msm_SEND_DURATION);
            Vcode vcode = vcodeService.applyVcode(mobile, expireAt, resendAt);

            String msg = vcode.getVcode();

            logger.info("msg_full_log: {}|{}|{}|{}", ip,
                    request.getHeader("Referer"), mobile, msg);

            smsService.sendCodeSms(mobile, msg);
            Map<String, Object> data = Maps.newHashMap();
            long reSendSecond = (vcode.getResendAt().getTime() - System.currentTimeMillis())
                    / 1000;
            data.put("reSendSecond", reSendSecond); // 兼容web的响应字段名
            data.put("seqId", vcode.getSeqId());
            return JsonUtil.successResultJson(data);
        }catch(Exception e){
            logger.error("Exception Send Vcode!", e);
            return JsonUtil.toJson(ErrorCodes.CORE_ERROR, "系统异常", null);
        }
    }

    /**
     * 手机短信确认码验证
     *
     * @throws Exception
     *             任何异常
     */
    @RequestMapping(value = {"/vcode/validate", "/vcode/validate/"}, method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String validate(HttpServletRequest request,
            HttpServletResponse response) {
        try{
            Map<String, Object> params = JsonUtil.readMapFromReq(request);
            if (!SignHelper.validateSign(params)) { // 签名验证失败
                return JsonUtil.toJson(ErrorCodes.SIGN_VALIDATE_ERROR, "签名验证失败",
                        null);
            }
            String mobile = (String) params.get("mobile");
            String code = (String) params.get("vcode");
            if(StringUtils.isBlank(mobile) || StringUtils.isBlank(code)){
                return JsonUtil.toJson(ErrorCodes.CORE_PARAM_NULL, "参数异常", null);
            }
            CodeMsg cm = vcodeService.validate(mobile, code);
            return JsonUtil.toJson(cm.getCode(), cm.getMsg(), null);
        }catch(Exception e){
            logger.error("Exception Validate Vcode!", e);
            return JsonUtil.toJson(ErrorCodes.CORE_ERROR, "系统异常", null);
        }
    }

}
