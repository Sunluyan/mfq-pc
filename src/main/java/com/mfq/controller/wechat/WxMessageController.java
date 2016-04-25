package com.mfq.controller.wechat;

import com.mfq.service.WeChatService;
import com.mfq.service.WxMessageService;
import com.mfq.utils.HttpUtil;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.XMLConverUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 * Created by liuzhiguo1 on 16/4/21.
 */
@Controller
public class WxMessageController{

    private static final Logger logger = LoggerFactory
            .getLogger(WxMessageController.class);

    @Resource
    WeChatService weChatService;
    @Resource
    WxMessageService service;

    @RequestMapping(value = "/wechat/receive",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody String receiveMessage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String xml = JsonUtil.readRequestString(request);
        Map<String, Object> soap = XMLConverUtil.convertSoapToMap(xml);

        if(soap.get("MsgType").toString().equals("text")){
            return service.textHandle(soap);
        }else if(soap.get("MsgType").toString().equals("event")){
            return service.eventHandle(soap);
        }
        return "";
    }





}

