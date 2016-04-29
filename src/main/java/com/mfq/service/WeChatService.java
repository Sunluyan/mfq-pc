package com.mfq.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.mfq.bean.SysConfig;
import com.mfq.bean.SysConfigExample;
import com.mfq.bean.wechat.WeChatMsg;
import com.mfq.bean.wechat.message.AccessToken;
import com.mfq.cache.WeChatJsApiTicketCacheUtils;
import com.mfq.constants.Constants;
import com.mfq.constants.ErrorCodes;
import com.mfq.dao.SysConfigMapper;
import com.mfq.dao.WeChatMsgMapper;
import com.mfq.helper.SignHelper;
import com.mfq.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class WeChatService {

    private static final Logger log = LoggerFactory
            .getLogger(WeChatService.class);
	
    @Resource
	WeChatMsgMapper weChatMsgMapper;
	@Resource
	SysConfigMapper sysConfigMapper;

	public static final String ACCESS_TOKEN = "access_token";
	
	public static final String EXPIRES_IN = "expires_in";
	
	public static final String CREATE_AT = "expires_in";
	
	public static final int TOKEN_IN = 7000;
    

	//生成随机数
	private static String genRandomPass(){
		int i = (int) (Math.random() * 1000000 + 100000);
		return String.valueOf(i);
	}

    /**
     * 保存微信消息
     * @param wechat
     * @return
     */
    public long saveWeChatMsg(WeChatMsg wechat){
    	return weChatMsgMapper.saveWeChatMsg(wechat);
    }
    
    public long saveWeChatMsg(Map<String, String> map){
    	WeChatMsg msg = new WeChatMsg();
    	msg.setToUserName(StringUtils.stripToEmpty(map.get("ToUserName")));
    	msg.setOpenId(StringUtils.stripToEmpty(map.get("FromUserName")));
    	msg.setCreateAt(DateUtil.getDateTimeBySeconds(map.get("CreateTime")));
    	msg.setMsgType(StringUtils.stripToEmpty(map.get("MsgType")));
    	msg.setPicUrl(StringUtils.stripToEmpty(map.get("PicUrl")));
    	msg.setContent(StringUtils.stripToEmpty(map.get("Content")));
    	msg.setMediaId(StringUtils.stripToEmpty(map.get("MediaId")));
    	msg.setMsgId(StringUtils.stripToEmpty(map.get("MsgId")));
    	return weChatMsgMapper.saveWeChatMsg(msg);
    }
    
	/**
	 * 获取accessToken
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public AccessToken getAccessToken() throws ParseException, IOException{
		SysConfigExample example = new SysConfigExample();
		example.or().andKeyEqualTo(Constants.WECHAT_TOKEN_KEY);
		List<SysConfig> config = sysConfigMapper.selectByExample(example);
		AccessToken token;
		if(config.size() != 0 && config.get(0).getValue() != null){
			token = JsonUtil.toBean(config.get(0).getValue(), AccessToken.class);
			if ((System.currentTimeMillis()- token.getCreateAt())/1000 < TOKEN_IN) {// 有效
				return token;
			}
		}
		//两种情况,压根没有 和 有但是失效了
		token = httpAccessToken(); //重新获取
		if(config.size() == 0){
			SysConfig sysConfig = new SysConfig();
			sysConfig.setKey(Constants.WECHAT_TOKEN_KEY);
			sysConfig.setValue(JsonUtil.writeToJson(token));
			sysConfigMapper.insertSelective(sysConfig);
		}else{
			SysConfig sysConfig = new SysConfig();
			sysConfig.setValue(JsonUtil.writeToJson(token));
			SysConfigExample example1 = new SysConfigExample();
			example1.or().andKeyEqualTo(Constants.WECHAT_TOKEN_KEY);
			sysConfigMapper.updateByExampleSelective(sysConfig,example1);
		}
		return token;
	}

	/**
	 * 获取微信js token
	 * @return
	 * @throws IOException
	 */
	public JSONObject getJSToken() throws IOException{
		SysConfigExample example = new SysConfigExample();
		example.or().andKeyEqualTo("WX_JS");
		List<SysConfig> config = sysConfigMapper.selectByExample(example);

		JSONObject token;
		if(config.size() != 0 && config.get(0).getValue() != null){
			token = JSONObject.parseObject(config.get(0).getValue());
			if ((System.currentTimeMillis()- token.getLong("create_at"))/1000 < TOKEN_IN) {// 有效
				return token;
			}
		}
		token = httpJSToken();
		token.put("create_at", System.currentTimeMillis()/1000);

		if(config.size() == 0){
			SysConfig sysConfig = new SysConfig();
			sysConfig.setKey("WX_JS");
			sysConfig.setValue(JsonUtil.writeToJson(token));
			sysConfigMapper.insertSelective(sysConfig);
		}else{
			SysConfig sysConfig = new SysConfig();
			sysConfig.setValue(JsonUtil.writeToJson(token));
			SysConfigExample example1 = new SysConfigExample();
			example1.or().andKeyEqualTo("WX_JS");
			sysConfigMapper.updateByExampleSelective(sysConfig,example1);
		}
		return token;
	}
	
	private JSONObject httpJSToken() throws ParseException, IOException{
		String url=Constants.ACCESS_JSTOKEN_URL.replace("ACCESS_TOKEN", getAccessToken().getToken());
		String result = HttpUtil.get(url, false);
		return JSONObject.parseObject(result);
	}
	
	private AccessToken httpAccessToken() throws IOException{
		String url = Constants.ACCESS_TOKEN_URL.replace("APPID", Constants.APPID).replace("APPSECRET", Constants.APPSECRET);
		String result = HttpUtil.get(url, false);
		AccessToken token = parseAccessToken(JSONObject.parseObject(result));
		token.setCreateAt(System.currentTimeMillis());
		return token;
	}
	
	private AccessToken parseAccessToken(JSONObject token){
		AccessToken wtoken = new AccessToken();
		wtoken.setToken(token.getString(ACCESS_TOKEN));
		wtoken.setExpiresIn(token.getIntValue(EXPIRES_IN));
		return wtoken;
	}
	
	/**
	 * 获取客服
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public JSONArray getKefu() throws IOException{
		String url = Constants.WECHAT_KF_URL.replace("ACCESS_TOKEN", getAccessToken().getToken());
		String result = HttpUtil.get(url, false);
		
		return JSONArray.parseArray(result);
	}
	
	/**
	 * 客服发送消息（异步消息）
	 * @return
	 * @throws IOException
	 */
	public String sendAsyncMessage(String toUser, String msgType, String content) throws IOException{
		String ret = "";
		JSONObject message = null;
		if(msgType.equals(MessageUtil.MESSAGE_TEXT)){
			message = MessageUtil.initKfTextMessage(toUser, content);
		}
		log.info("wechat sendMessgae is {}",message.toJSONString());
		System.out.println(message.toJSONString());
		String url = Constants.WECHAT_SEND_MESSAGE.replace("ACCESS_TOKEN", getAccessToken().getToken());
		String result = HttpUtil.post(url, message.toJSONString(), false);
		JSONObject re = JSONObject.parseObject(result);
		
		int code = re.getInteger("errcode");
		String msg = re.getString("errmsg");
		if( code == 0){
			ret = JsonUtil.successResultJson(msg);
		}else {
			ret = JsonUtil.toJson(code, msg, null);
			log.warn(" wechat sendMessage fild , return msg is {}", result);
		}
		return ret;
	}

	/**
	 * 获取关注用户信息
	 * @param openId
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String queryUser(String openId) throws ParseException, IOException {
		if(openId == null){
			log.error("参数不合法！OpenId is null");
			return JsonUtil.toJson(ErrorCodes.CORE_PARAM_UNLAWFUL, "参数不合法", null);
            
		}
		String url = Constants.WECHAT_QUERY_USER.replace("ACCESS_TOKEN", getAccessToken().getToken()).replace("OPENID", openId);
		String result = HttpUtil.get(url, false);
		JSONObject re = JSONObject.parseObject(result);
		return JsonUtil.successResultJson(re);
	}
	
	/**
	 * 获取图片信息
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public InputStream queryMedia(String media) throws ParseException, IOException {
		if(media == null){
			log.error("参数不合法！media is null");
			return null;
            
		}
		JSONObject params = new JSONObject();
		params.put("media_id", media);
		
		String url = Constants.WECHAT_FOREVER_MEDIA.replace("ACCESS_TOKEN", getAccessToken().getToken()).replace("MEDIA_ID", media);
		InputStream result = HttpUtil.postMedia(url, params.toJSONString());
		return result;
	}
	
	
	/**
	 * 获取js api token
	 * @return
     */
	public String generateJsApiToken(String url){
		//先获取jsapi_ticket
		log.info("enter to generateJsApiToken");
		try{
			JSONObject ticket_js = getJSApiTicket();
			if(ticket_js == null){
				return JsonUtil.toJson(1001, "ticket 获取失败", null);
			}
			if("".equals(url)){
				return JsonUtil.toJson(1002, "url 参数错误", null);
			}
			Map<String, Object> params= Maps.newHashMap();
			String  ticket =ticket_js.getString("ticket");
			String nonceStr = genNonceStr();
			String timestamp = (System.currentTimeMillis()/1000)+"";
			params.put("noncestr", nonceStr);
			params.put("timestamp", timestamp);
			params.put("url", url);
			params.put("jsapi_ticket", ticket);
			String sign = SignHelper.makeWxSign(params);
			log.info("sign"+sign);
			Map<String,Object> data = Maps.newHashMap();
			data.put("appId", Constants.APPID);
			data.put("timestamp", timestamp);
			data.put("nonceStr", nonceStr);
			data.put("signature", sign);
			return JsonUtil.successResultJson(data);
		}catch(Exception e){
			log.error(""+e);
		}

		return null;
	}

	private String genNonceStr() {
		Random random = new Random();
		return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
	}

	private JSONObject getJSApiTicket(){
		try{
			String accessToken = HttpUtil.get(StringUtils.replace("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET","APPID",Constants.APPID).replace("APPSECRET", Constants.APPSECRET),false);
			String ticket = HttpUtil.get(StringUtils.replace("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi","ACCESS_TOKEN", JSONObject.parseObject(accessToken).getString("access_token")),false);
			log.info(JSONObject.parseObject(accessToken).getString("access_token"));

			//String ticket = WeChatJsApiTicketCacheUtils.getTicket();
			log.info("ticket:{}"+ticket);
			if(ticket != null){
				return JSON.parseObject(ticket);
			}
			//ticket为null的话,就重新获取一遍
			String url = Constants.WECHAT_JS_TICKET.replace("ACCESS_TOKEN", getAccessToken().getToken());
			String result = HttpUtil.get(url, false);
			if(JSONObject.parseObject(result).getInteger("errcode") == 0){
				WeChatJsApiTicketCacheUtils.cacheTicket(result);
				return JSON.parseObject(result);
			}else{
				log.info("get js ticket return result is error result = {}", result);
			}
			
		}catch (Exception e){
			log.info("get js ticket is error {}", e);
		}
		return null;
	}


	/**
	 * 定义微信菜单
	 *
	 * {
		 "button": [
		 {
		 "name": "我的分期",
		 "type": "view",
		 "url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdcf80505a7671ba0&redirect_uri=http%3A%2F%2Ftest.iyeeda.com%2Fmy&response_type=code&scope=snsapi_base&state=123123#wechat_redirect"
		 },
		 {
		 "name": "我的订单",
		 "type": "view",
		 "url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdcf80505a7671ba0&redirect_uri=http%3A%2F%2Ftest.iyeeda.com%2Fconfirm&response_type=code&scope=snsapi_base&state=123123#wechat_redirect"
		 },

		 {
		 "name":"咨询客服",
		 "type":"view",
		 "url":"http://www.sobot.com/chat/h5/index.html?sysNum=c3c7fc4f6f84467ab9a32452e9284ecb&source=1"
		 }
		 ]
		 }
	 * @throws Exception
     */
	public void initMenu() throws Exception {
		String body = "{\"button\":[{\"name\":\"我的分期\",\"sub_button\":[{\"type\":\"view\",\"name\":\"我的分期\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdcf80505a7671ba0&redirect_uri=http%3A%2F%2Ftest.iyeeda.com%2Fmy&response_type=code&scope=snsapi_base&state=123123#wechat_redirect\"},{\"type\":\"view\",\"name\":\"申请分期\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdcf80505a7671ba0&redirect_uri=http%3A%2F%2Ftest.iyeeda.com%2Fapply&response_type=code&scope=snsapi_base&state=123123#wechat_redirect\"},{\"type\":\"view\",\"name\":\"完整资料\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdcf80505a7671ba0&redirect_uri=http%3A%2F%2Ftest.iyeeda.com%2Fbase&response_type=code&scope=snsapi_base&state=123123#wechat_redirect\"}]},{\"name\":\"我的订单\",\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdcf80505a7671ba0&redirect_uri=http%3A%2F%2Ftest.iyeeda.com%2Fconfirm&response_type=code&scope=snsapi_base&state=123123#wechat_redirect\"},{\"name\":\"咨询客服\",\"type\":\"view\",\"url\":\"http://www.sobot.com/chat/h5/index.html?sysNum=c3c7fc4f6f84467ab9a32452e9284ecb&source=1\"}]}";
		String resp = HttpUtil.postJson("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+getAccessToken().getToken(),body,false);
		log.info(resp);
	}

	public String getQRTicket() throws IOException {
		String body = "{\"action_name\":\"QR_LIMIT_SCENE\",\"action_info\":{\"scene\":{\"scene_id\":1}}}";
		String resp = HttpUtil.postJson("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+getAccessToken().getToken(),body,false);
		log.info(resp);
		return resp;
	}

	public static void testGetJsTicket(){
		Map<String,Object> map = new HashMap<>();
		map.put("order_no","wbl2016042714040128912539,wbl2016042714040175472539,wbl2016042714040110302539");
		map.put("uid",9529);
		map.put("amount",416.67*3);
		map.put("sign",SignHelper.makeSign(map));
		String body = JsonUtil.writeToJson(map);
		String resp = HttpUtil.postJson("http://106.75.6.128/pay/mobile_pay/wechat.do",body,false);
		System.out.println(resp);
	}

	public static void testGetConfig(){
		Map<String,Object> map = new HashMap<>();
		map.put("url","http://test.iyeeda.com/my/all/wmn2016042615190326312539");
		String body = JsonUtil.writeToJson(map);
		String ret = HttpUtil.postJson("http://m.5imfq.com/wechat/js/token",body,false);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
		WeChatService service = ac.getBean(WeChatService.class);
		service.initMenu();
//		testGetConfig();
	}

}