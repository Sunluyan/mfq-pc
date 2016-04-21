package com.mfq.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfq.bean.Users;
import com.mfq.bean.juxinli.stepThree.Req_msg_tpl;
import com.mfq.bean.juxinli.stepTwo.Data;
import com.mfq.bean.juxinli.stepTwo.Datasource;
import com.mfq.bean.juxinli.stepTwo.Root;
import com.mfq.dao.JuxinliMapper;
import com.mfq.utils.HttpUtil;
import com.mfq.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzhiguo1 on 16/4/20.
 */
@Service
public class JuxinliService {

    private static final Logger logger = LoggerFactory
            .getLogger(JuxinliService.class);
    @Resource
    JuxinliMapper mapper;
    @Resource
    UserService userService;

    public static List<Datasource> staticDatasources = null;

    /**
     * 这一步,获取数据源.
       https://www.juxinli.com/orgApi/rest/v2/orgs/meilifenqi/datasources
     * @return
     */
    public static String init() throws IOException {
        if(staticDatasources != null){
            return JsonUtil.successResultJson(staticDatasources);
        }
        String resp = HttpUtil.get("https://www.juxinli.com/orgApi/rest/v2/orgs/meilifenqi/datasources",true);
        JSONObject object = JSON.parseObject(resp);
        JSONArray array = object.getJSONArray("data");
        List<Datasource> datasources = new ArrayList<>();

        for(int i = 0;i<array.size();i++){
            Datasource datasource = JsonUtil.toBean(array.get(i).toString(),Datasource.class);
            datasources.add(datasource);
        }
        if(staticDatasources == null){
            staticDatasources = datasources;
        }
        return JsonUtil.successResultJson(datasources);
    }

    //进入到采集服务密码
    public String oneStep(Long uid ,List<Datasource> datasources) throws Exception {
        Users user = userService.selectByUid(uid);

        Map<String,Object> map = new HashMap<>();
        Map<String,Object> basicInfo = new HashMap<>();
        basicInfo.put("cell_phone_num",user.getMobile());
        basicInfo.put("id_card_num",user.getCardId());
        basicInfo.put("name",user.getRealname());
        map.put("basic_info",basicInfo);//basicInfo

        List<Map<String,Object>> selectedWebsite = new ArrayList<>();
        for (Datasource datasource : datasources) {
            Map<String,Object> website = new HashMap<>();
            website.put("category",datasource.getCategory());
            website.put("name",datasource.getWebsite());
            selectedWebsite.add(website);
        }

        map.put("selected_website",selectedWebsite);//selectedWebsite
        map.put("skip_mobile",false);//skip_mobile
        String body = JsonUtil.writeToJson(map);
        String resp = HttpUtil.postJson("https://www.juxinli.com/orgApi/rest/v2/applications/meilifenqi",
                body,false);
        System.out.println(resp);
        Root root = JsonUtil.toBean(resp,Root.class);
        if(root.getSuccess() == false){
            throw new Exception("出错了,请重试或联系工程师");
        }

        Data data = JsonUtil.toBean(JsonUtil.writeToJson(root.getData()),Data.class);
//        Datasource datasource = JsonUtil.toBean(JsonUtil.writeToJson(data.getDatasource()),Datasource.class);
//        System.out.println(datasource.toString());


        return JsonUtil.successResultJson(data);
    }


    //开始采集服务密码
    public String twoStep(Long uid , Data stepTwoData , String password , HttpSession session) throws Exception {
        Users user = userService.selectByUid(uid);

        Map<String,Object> map = new HashMap<>();
        map.put("token",stepTwoData.getToken());
        map.put("website",stepTwoData.getDatasource().getWebsite());
        map.put("account",user.getMobile());
        map.put("password",password);
        map.put("captcha","");
        map.put("type","");

        String body = JsonUtil.writeToJson(map);
        String resp = HttpUtil.postJson("https://www.juxinli.com/orgApi/rest/v2/messages/collect/req",
                body,false);
        System.out.println(resp);
        com.mfq.bean.juxinli.stepThree.Root root =JsonUtil.toBean(resp, com.mfq.bean.juxinli.stepThree.Root.class);
        com.mfq.bean.juxinli.stepThree.Data data = root.getData();

        if(data.getType().equals("ERROR")){
            throw new Exception(data.getContent());
        }
        if(data.getProcess_code() == 10003) {
            throw new Exception(data.getContent());
        }
        if(data != null && data.getReq_msg_tpl() != null){
            session.setAttribute("type",data.getReq_msg_tpl().getType());
        }
        if(root.getSuccess() == false){
            return JsonUtil.toJson(9999,"出错了,请重试或联系工程师",null);
        }

        return JsonUtil.successResultJson(data);
    }


    /**
     * 开始采集动态密码
     * @param uid
     * @param stepTwoData
     * @param password
     * @param captcha
     * @param type
     * @param session
     * @return
     * @throws Exception
     */
    public String threeStep(Long uid ,Data stepTwoData , String password , String captcha ,String type , HttpSession session) throws Exception {
        Users user = userService.selectByUid(uid);

        Map<String,Object> map = new HashMap<>();
        map.put("token",stepTwoData.getToken());
        map.put("website",stepTwoData.getDatasource().getWebsite());
        map.put("account",user.getMobile());
        map.put("password",password);
        map.put("captcha",captcha);
        map.put("type",type);

        String body = JsonUtil.writeToJson(map);
        String resp = HttpUtil.postJson("https://www.juxinli.com/orgApi/rest/v2/messages/collect/req",
                body,false);
        System.out.println(resp);
        com.mfq.bean.juxinli.stepThree.Root root =JsonUtil.toBean(resp, com.mfq.bean.juxinli.stepThree.Root.class);
        com.mfq.bean.juxinli.stepThree.Data data = root.getData();

        if(StringUtils.isNotBlank(captcha)){
            session.setAttribute("captcha",captcha);
        }
        if(data.getNext_datasource() != null){
            session.setAttribute("nextDatasource",data.getNext_datasource());
        }
        if(data.getProcess_code() == 30000){
            throw new Exception(data.getContent());
        }
        if(root.getSuccess() == false){
            throw new Exception("请求出错,请联系工程师解决");
        }

        return JsonUtil.successResultJson(data);
    }

    public String fourStep(Long uid ,Data stepTwoData , String password , String captcha ,String account , String type , HttpSession session) throws Exception {
        Users user = userService.selectByUid(uid);

        Map<String,Object> map = new HashMap<>();
        map.put("token",stepTwoData.getToken());
        Datasource datasource = (Datasource) session.getAttribute("nextDatasource");
        map.put("website",datasource.getWebsite());
        map.put("account",account);
        map.put("password",password);
        map.put("captcha",captcha);
        map.put("type",type);

        String body = JsonUtil.writeToJson(map);
        String resp = HttpUtil.postJson("https://www.juxinli.com/orgApi/rest/v2/messages/collect/req",
                body,false);
        System.out.println(resp);
        com.mfq.bean.juxinli.stepThree.Root root =JsonUtil.toBean(resp, com.mfq.bean.juxinli.stepThree.Root.class);
        com.mfq.bean.juxinli.stepThree.Data data = root.getData();


        if(data.getType().equals("ERROR")){
            throw new Exception(data.getContent());
        }
        session.setAttribute("finish",data.getFinish());
        session.setAttribute("nextDatasource",data.getNext_datasource());
        if(data.getProcess_code() == 30000){
            throw new Exception(data.getContent());
        }
        if(root.getSuccess() == false){
            throw new Exception("请求出错,请联系工程师解决");
        }

        return JsonUtil.successResultJson(data);
    }


    public String resetServerPwd(Long uid ,Data stepTwoData , String newPassword , String captcha ,String account , String type , HttpSession session) throws Exception {
        Users user = userService.selectByUid(uid);

        Map<String,Object> map = new HashMap<>();
        map.put("token",stepTwoData.getToken());
        map.put("website",stepTwoData.getDatasource().getWebsite());
        map.put("account",user.getMobile());
        map.put("password",newPassword);
        map.put("captcha",captcha);
        map.put("type","");

        String body = JsonUtil.writeToJson(map);
        String resp = HttpUtil.postJson("https://www.juxinli.com/orgApi/rest/v2/messages/collect/req",
                body,false);
        System.out.println(resp);
        com.mfq.bean.juxinli.stepThree.Root root =JsonUtil.toBean(resp, com.mfq.bean.juxinli.stepThree.Root.class);
        com.mfq.bean.juxinli.stepThree.Data data = root.getData();


        if(data.getType().equals("ERROR")){
            throw new Exception(data.getContent());
        }
        session.setAttribute("finish",data.getFinish());
        session.setAttribute("nextDatasource",data.getNext_datasource());
        if(data.getProcess_code() == 30000){
            throw new Exception(data.getContent());
        }
        if(root.getSuccess() == false){
            throw new Exception("请求出错,请联系工程师解决");
        }

        return JsonUtil.successResultJson(data);
    }







    public static void main(String[] args) throws IOException {
        init();
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
//        JuxinliService service = ac.getBean(JuxinliService.class);
//        List<Datasource> datasources = new ArrayList<>();
//        Datasource datasource = new Datasource();
//        datasource.setName("jingdong");
//        datasource.setCategory("e_business");
//        datasources.add(datasource);
//
//        Datasource datasource1 = new Datasource();
//        datasource1.setName("taobao");
//        datasource1.setCategory("e_business");
//        datasources.add(datasource1);
//        service.oneStep(9527l,datasources);


//        Data data = new Data();
//        data.setToken("19c90dbf791f4000988c02d7818c8617");
//        service.twoThree(9527l,data,"149527","077798","SUBMIT_CAPTCHA");
        //{"success":true,"data":{"type":"CONTROL","content":"开始采集行为数据","process_code":10008,"next_datasource":{"id":"df8ba6ec822e4984b3556d2a2cc2d5b8","website":"jingdong","name":"京东","category":"e_business","category_name":"电商","create_time":{"year":2014,"month":6,"dayOfMonth":7,"hourOfDay":10,"minute":49,"second":14},"update_time":{"year":2014,"month":9,"dayOfMonth":17,"hourOfDay":12,"minute":22,"second":49},"offline_times":6,"status":1,"website_code":4,"reset_pwd_method":0,"sms_required":0,"required_captcha_user_identified":0},"finish":false}}

    }



}
