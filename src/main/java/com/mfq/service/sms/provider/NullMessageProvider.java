package com.mfq.service.sms.provider;

import com.mfq.constants.SmsConstants;

import java.util.Date;
import java.util.Map;

/**
 * Null provider.
 * Default－空的供应商，返回报错
 */
public class NullMessageProvider extends MessageProvider {
	
	//对于nullMessageProvider 来说 id 永远是null
    String id = "null";

    @Override
    public void loadConfiguration(Map<String, Object> setting) {
    }

    @Override
    public String getBalance() {
        return SmsConstants.ERROR_SERVER;
    }

    @Override
    public String sendBatchMessage(String content, String mobiles) {
        return SmsConstants.ERROR_SERVER;
    }

    @Override
    public String sendVcodeMessage(String content, String mobile) {
        return SmsConstants.ERROR_SERVER;
    }

    @Override
    public String sendSingleMessage(String content, String mobile) {
        return SmsConstants.ERROR_SERVER;
    }

    @Override
    public String sendSingleMessageBytime(String content, String mobile, Date sendtime) {
        return SmsConstants.ERROR_SERVER;
    }
}
