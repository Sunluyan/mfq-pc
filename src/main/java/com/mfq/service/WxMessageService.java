package com.mfq.service;

import com.mfq.bean.OrderInfoExample;
import com.mfq.bean.Users;
import com.mfq.bean.WechatEvent;
import com.mfq.bean.WechatEventWithBLOBs;
import com.mfq.bean.wechat.message.News;
import com.mfq.bean.wechat.message.NewsMessage;
import com.mfq.bean.wechat.message.TextMessage;
import com.mfq.constants.AuthStatus;
import com.mfq.constants.Constants;
import com.mfq.constants.WechatMessageType;
import com.mfq.dao.OpenidUidMapper;
import com.mfq.dao.OrderInfoMapper;
import com.mfq.dao.UsersMapper;
import com.mfq.dao.WechatEventMapper;
import com.mfq.utils.XMLConverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzhiguo1 on 16/4/22.
 */
@Service
public class WxMessageService {

    private static final Logger logger = LoggerFactory
            .getLogger(WxMessageService.class);


    @Resource
    WechatEventMapper mapper;
    @Resource
    OpenidUidMapper openidUidMapper;
    @Resource
    OrderInfoMapper orderInfoMapper;
    @Resource
    UsersMapper usersMapper;
    @Resource
    UserService userService;
    /**
     * 处理微信文本类信息
     * @return
     */
    public String textHandle(Map<String,Object> text){

        TextMessage textMessage = new TextMessage();
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setMsgType("text");
        textMessage.setToUserName(text.get("FromUserName").toString());
        textMessage.setFromUserName(Constants.WECHAT_USER_NAME);

        String content = text.get("Content").toString();
        if(content.equals("。。")){
            textMessage.setContent("不许说。。");
        }
        String openId = text.get("FromUserName").toString();
        long uid = openidUidMapper.selectByPrimaryKey(openId).getUid();

        if(content.equals("清除订单")){
            OrderInfoExample example = new OrderInfoExample();
            example.or().andUidEqualTo(uid);
            orderInfoMapper.deleteByExample(example);
            textMessage.setContent("清除成功");
        }
        else if(content.equals("清除所有资料")){
            userService.changeUserStatusForWechat(uid,AuthStatus.INIT);
            textMessage.setContent("清除成功");
        }
        else if(content.equals("清除基本资料")){
            userService.changeUserStatusForWechat(uid,AuthStatus.INIT);
            textMessage.setContent("清除成功");
        }
        else if(content.equals("清除身份资料")){
            userService.changeUserStatusForWechat(uid,AuthStatus.BASE);
            textMessage.setContent("清除成功");

        }
        else if(content.equals("清除征信资料")){
            userService.changeUserStatusForWechat(uid,AuthStatus.USERTYPEDETAIL);
            textMessage.setContent("清除成功");
        }

        else{
            return "";
        }



        String xml = XMLConverUtil.writeObj2Xml(textMessage);
        xml = xml.replaceAll("com.mfq.bean.wechat.message.TextMessage","xml");
        logger.info("xml result = "+xml);

        return xml;
    }



    public String eventHandle(Map<String,Object> text){

        if(text.get("Event").equals("VIEW")){
            return "";
        }
        Integer eventId = null;
        if(text.get("EventKey").toString().contains("_")){
            eventId = Integer.parseInt(text.get("EventKey").toString().split("_")[1]);
        }
        else{
            eventId = Integer.parseInt(text.get("EventKey").toString());
        }

        logger.info(text.toString());
        WechatEventWithBLOBs event = mapper.selectByPrimaryKey(eventId);
        if(event.getType() == WechatMessageType.ARTICLE.getId()){
            return sendArticlesByEvent(event , text);
        }
        else if(event.getType() == WechatMessageType.TEXT.getId()){

        }
        else if(event.getType() == WechatMessageType.VOICE.getId()){

        }
        else if(event.getType() == WechatMessageType.IMAGE.getId()){

        }

        return "";

    }


    /**
     * 发送图文消息
     * @param event
     * @param text
     * @return
     */
    public String sendArticlesByEvent(WechatEventWithBLOBs event ,Map<String,Object> text){

        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setMsgType(WechatMessageType.ARTICLE.getTypeDesc());
        newsMessage.setCreateTime(System.currentTimeMillis());
        newsMessage.setFromUserName(Constants.WECHAT_USER_NAME);
        newsMessage.setToUserName(text.get("FromUserName").toString());

        int articleCount = event.getArticlesTitle().split(";").length;

        newsMessage.setArticleCount(articleCount);
        List<News> articles = new ArrayList<>();
        for(int i = 0;i<articleCount;i++){
            News news = new News();
            news.setTitle(event.getArticlesTitle().split(";")[i]);
            news.setDescription(event.getArticlesDesc().split(";")[i]);
            news.setUrl(event.getArticlesUrl().split(";")[i]);
            news.setPicUrl(event.getArticlesPicUrl().split(";")[i]);
            articles.add(news);
        }
        newsMessage.setArticles(articles);
        String xml = XMLConverUtil.writeObj2Xml(newsMessage);
        xml = xml.replaceAll("com.mfq.bean.wechat.message.NewsMessage","xml");
        xml = xml.replaceAll("com.mfq.bean.wechat.message.News","item");
        logger.info(xml);
        return xml;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
        WechatEventMapper mapper = ac.getBean(WechatEventMapper.class);
        WechatEventWithBLOBs event = mapper.selectByPrimaryKey(1);
        System.out.println(event.toString());
        int articleCount = event.getArticlesTitle().split(";").length;
        List<News> articles = new ArrayList<>();
        for(int i = 0;i<articleCount;i++){
            News news = new News();
            news.setTitle(event.getArticlesTitle().split(";")[i]);
            news.setDescription(event.getArticlesDesc().split(";")[i]);
            news.setUrl(event.getArticlesUrl().split(";")[i]);
            news.setPicUrl(event.getArticlesPicUrl().split(";")[i]);
            articles.add(news);
        }

    }



}
