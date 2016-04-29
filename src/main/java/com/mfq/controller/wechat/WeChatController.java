package com.mfq.controller.wechat;

import com.mfq.constants.ErrorCodes;
import com.mfq.helper.SignHelper;
import com.mfq.service.WeChatService;
import com.mfq.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.ParseException;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private static final Logger logger = LoggerFactory
            .getLogger(WeChatController.class);

    @Resource
    WeChatService weChatService;


    /**
     * 消息处理
     *
     * @param request
     *            请求
     * @param response
     *            响应
     * @throws Exception
     *             任何异常
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String doMessage(HttpServletRequest request,
            HttpServletResponse response) {
    	PrintWriter out = null;
		try {
			
			request.setCharacterEncoding("UTF-8");
	    	response.setCharacterEncoding("UTF-8");
	    	out = response.getWriter();
			
			Map<String, String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			logger.info("微信消息请求 content = {}| fromUserName = {}| toUserName = {}| msgType = {}",content, fromUserName, toUserName, msgType );
			String message = "success";
			if(MessageUtil.MESSAGE_IMAGE.equals(msgType)){
				long result = weChatService.saveWeChatMsg(map);
				if(result > 0){
					message = MessageUtil.initText(toUserName, fromUserName, "消息已提交。。 ");
				}else{
					message = MessageUtil.initText(toUserName, fromUserName, "暂时无法提供服务，请稍后再试。");
				}
			}else if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				weChatService.saveWeChatMsg(map);
				if(content.startsWith("产品")){
					message = MessageUtil.initText(toUserName, fromUserName, "欢迎关注美分期产品。");
				}
			}else{
				//待处理。。。
				message = MessageUtil.initText(toUserName, fromUserName, "欢迎关注美分期。。。 ");
			}
			
			logger.info("wechat ret message {}",message);
			out.print(message);
		} catch (DocumentException e) {
			logger.info("wechat ret message DocumentException {}",e);
		}catch (Exception e) {
			logger.info("wechat ret message Exception {}",e);
		}finally{
			out.close();
		}
    	return null;
    }
    
    /**
     * 发送消息
     *
     * @param request
     *            请求
     * @param response
     *            响应
     * @throws Exception
     *             任何异常
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public String sendMessage(HttpServletRequest request,
            HttpServletResponse response) {
        String ret = "";
        try{
            Map<String, Object> params = JsonUtil.readMapFromReq(request);
            if (!SignHelper.validateSign(params)) { // 签名验证失败
                ret = JsonUtil.toJson(ErrorCodes.SIGN_VALIDATE_ERROR, "签名验证失败",
                        null);
                logger.error("签名验证失败！ret={}", ret);
                return ret;
            }
            if(params.get("msgType") == null && params.get("msg") == null && params.get("user") == null){
                ret = JsonUtil.toJson(ErrorCodes.CORE_PARAM_UNLAWFUL, "参数不合法", null);
                logger.error("参数不合法！ret={}", ret);
                return ret;
            }
            String msgType = params.get("msgType").toString();
            String msg = params.get("msg").toString();
            String user = params.get("user").toString();
            ret = weChatService.sendAsyncMessage(user, msgType, msg);
        }catch(Exception e){
        	logger.info("WeChat SendMsg Exception: {}",e);
        }
    	return ret;
    }
    
    /**
     * 查询用户
     *
     * @param request
     *            请求
     * @param response
     *            响应
     * @throws Exception
     *             任何异常
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String findUser(HttpServletRequest request,
            HttpServletResponse response) {
    	String ret = "";
    	try{
	    	Map<String, Object> params = JsonUtil.readMapFromReq(request);
	        if (!SignHelper.validateSign(params)) { // 签名验证失败
	            ret = JsonUtil.toJson(ErrorCodes.SIGN_VALIDATE_ERROR, "签名验证失败",
	                    null);
	            logger.error("签名验证失败！ret={}", ret);
	            return ret;
	        }
	        if(params.get("openid") == null){
	            ret = JsonUtil.toJson(ErrorCodes.CORE_PARAM_UNLAWFUL, "参数不合法", null);
	            logger.error("参数不合法！ret={}", ret);
	            return ret;
	        }
	    	String openId = params.get("openid").toString();
	    	ret = weChatService.queryUser(openId);
    	}catch(ParseException e){
    		
    	}catch(IOException e){
    		
    	}catch(Exception e){
    		
    	}
    	return null;
    }
    
    /**
     * 获取媒体
     *
     * @param request
     *            请求
     * @param response
     *            响应
     * @throws IOException 
     * @throws Exception
     *             任何异常
     */
    @RequestMapping(value = "/image", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String findMedia(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
    	String ret = "";
    	InputStream in = null;
    	try{
    		Map<String, Object> params = JsonUtil.readMapFromReq(request);
	        if (!SignHelper.validateSign(params)) { // 签名验证失败
	            ret = JsonUtil.toJson(ErrorCodes.SIGN_VALIDATE_ERROR, "签名验证失败",
	                    null);
	            logger.error("签名验证失败！ret={}", ret);
	            return ret;
	        }
    		if(params.get("mediaid") == null){
	            ret = JsonUtil.toJson(ErrorCodes.CORE_PARAM_UNLAWFUL, "参数不合法", null);
	            logger.error("参数不合法！ret={}", ret);
	            return ret;
	        }

	        String media = params.get("mediaid").toString();
	        
	        in = weChatService.queryMedia(media);
	        OutputStream out = response.getOutputStream(); 
	        
	        byte buffer[] = new byte[1024];  
            int len = 0;  
            while((len=in.read(buffer))>0){  
                out.write(buffer,0,len);  
            }
	        
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{  
            if(in!=null){  
                in.close();     //关闭流  
            }  
        }  
    	
    	return ret;
    }

    /**
     * 注册（微信） 跳转
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = { "/register" }, method = { RequestMethod.GET })
    public ModelAndView register(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("title", "会员注册");
        try {
            // 随机产生用户id(用于验证请求）
            String uid = UUID.randomUUID().toString();
            model.put("UID", uid);
            // 保存至Session
            request.getSession().setAttribute("uid", uid);
        } catch (Exception e) {
            logger.error("WeiXin_REGISTER_Exception", e);
        }
        return new ModelAndView("/wechat/register", model);
    }

    @RequestMapping(value = { "/reg_ret" }, method = { RequestMethod.GET })
    public ModelAndView registerRet(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String code = request.getParameter("code");
        String msg = request.getParameter("msg");
        model.put("code", code);
        model.put("msg", msg);
        return new ModelAndView("/activity/s/reg_success", model);
    }


    /**
     * 扫描二维码跳转
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = { "/qr_coupons","/qr_coupons/"}, method = { RequestMethod.GET })
    public ModelAndView ScanQRcode(HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("title", "二维码");
        try {
            // 随机产生用户id(用于验证请求）
            String token = UUID.randomUUID().toString();
            model.put("token", token);
            // 保存至Session
            request.getSession().setAttribute("uid", token);

        } catch (Exception e) {
            logger.error("ScanQRCode_Exception", e);
            model.put("msg", "系统错误，请稍后重试！！");
            return new ModelAndView("/wechat/message", model);
        }
        return new ModelAndView("/wechat/QRCode", model);
    }


//    @RequestMapping(value = {"/js/token/","/js/token"}, method = { RequestMethod.GET, RequestMethod.POST })
//    @ResponseBody
//    public String JsApiToken(HttpServletRequest request) {
//        String ret = "";
//        try {
//            String url = StringUtils.stripToEmpty(request.getParameter("url"));
//            ret = weChatService.generateJsApiToken(url);
//            logger.info("ret:{}",ret);
//        } catch (Exception e) {
//            logger.info("gen js api token {}", e);
//        }
//
//        return ret;
//    }
    @RequestMapping(value = {"/js/token/","/js/token"}, method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String JsApiToken(HttpServletRequest request) {
        String ret = "";
        try {
            String url = StringUtils.stripToEmpty(request.getParameter("url"));
            Map<String,Object> map = new HashMap<>();
            map.put("url",url);
            logger.info("url : "+url);
            String body = JsonUtil.writeToJson(map);
            ret = HttpUtil.get("http://m.5imfq.com/wechat/js/token?url="+url,false);
            logger.info("ret:{}",ret);
        } catch (Exception e) {
            logger.info("gen js api token {}", e);
        }

        return ret;
    }

    @RequestMapping(value = {"/notwechat","/notwechat/"},method = {RequestMethod.POST,RequestMethod.GET})
    public String notWechat(Model model){
        model.addAttribute("msg","请在微信环境下打开");
        return "/error/error";
    }


    @RequestMapping(value = "/pay/mobile_pay/{tpp}.do", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String mobileGoPay(@PathVariable String tpp, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = JsonUtil.readMapFromReq(request);
        map.put("order_no",request.getParameter("order_no"));
        map.put("uid",request.getParameter("uid"));
        map.put("amount",request.getParameter("amount"));
        String body = JsonUtil.writeToJson(map);
        String resp = HttpUtil.postJson("http://106.75.6.128/pay/mobile_pay/"+tpp+".do",body,false);

        return resp;
    }

}
