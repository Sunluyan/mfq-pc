package com.mfq.payment;

import com.mfq.bean.PayCallbackResult;
import com.mfq.constants.Constants;
import com.mfq.constants.OrderType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public abstract class BasePaymentService {

    public static String callbackTmpl = "http://" + Constants.SITE_DOMAIN
            + "/pay/mobile_callback/{tpp}.do";

    public abstract String goPay(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> params,
            OrderType orderType);

    public abstract PayCallbackResult payCallback(HttpServletRequest request,
                                                  HttpServletResponse response, String ret);
    
    public abstract void refund();

    public abstract String queryPay(String orderNo);

    public abstract String buildPayCallbackURL();

}