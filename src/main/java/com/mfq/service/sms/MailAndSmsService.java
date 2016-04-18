package com.mfq.service.sms;

import com.mfq.bean.Vcode;
import com.mfq.cache.MsgTmplContext;
import com.mfq.constants.Constants;
import com.mfq.service.VcodeService;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.SecretDesUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MailAndSmsService {

    private static Logger logger = LoggerFactory
            .getLogger(MailAndSmsService.class);

    private static long MAIL_EXPIRE_DURATION = TimeUnit.DAYS.toMillis(2);// 激活链接两天有效
    private static long SEND_DURATION = TimeUnit.MINUTES.toMillis(5);// 重发间隔5分钟
    private long MOBILE_EXPIRE_DURATION = 1000 * 60 * 30; // 30分钟有效
    private long Msm_SEND_DURATION = 1000 * 60 * 2; // 重发时间2分钟

    @Resource
    VcodeService vcodeService;
    @Resource
    SMSInnerService smsService;

    public String sendResetSms(String nick, String mobile) throws Exception {
        Vcode applyvcode = vcodeService.applyVcode(mobile,
                new Date(System.currentTimeMillis() + MOBILE_EXPIRE_DURATION),
                new Date(System.currentTimeMillis() + Msm_SEND_DURATION));
//        Object[] params = new Object[] {
//        		nick,
//                applyvcode.getVcode()
//                };

//        smsService.sendVcodeMessage(
//                buildFragment("mobile_reset_verification", params, true), mobile);

        smsService.sendVcodeMessage(applyvcode.getVcode(), mobile, true);

        Map<String, Object> reData = new HashMap<String, Object>();
        reData.put("reSendSecond",
                (applyvcode.getResendAt().getTime() - System.currentTimeMillis()) / 1000);
        return JsonUtil.successResultJson(reData);
    }

    protected String buildFragment(String key, Object[] params, boolean isSms)
            throws Exception {
        String tmplText = "";
        if (isSms) {
            tmplText = MsgTmplContext.getSmsTmpl(key);
        } else {
            tmplText = MsgTmplContext.getMailTmpl(key);
        }
        String msgContent = null;
        if (StringUtils.isBlank(tmplText)) {
            logger.warn("{} 短信模板未找到!", new Object[] { key });
            return msgContent;
        }
        // 短信或邮件一起处理
        MessageFormat messageFormat = new MessageFormat(tmplText);
        if (params == null) {
            logger.warn("{} 短信参数未找到", new Object[] { key });
            return messageFormat.toString();
        }
        msgContent = messageFormat.format(params);
        if (StringUtils.isBlank(msgContent)) {
            logger.warn("SMS content is null!");
        } else {
            logger.info(
                    "\n-------------------------------------- smsContent: {}",
                    msgContent);
        }
        return msgContent;
    }
}