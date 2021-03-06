package com.mfq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfq.bean.OrderInfo;
import com.mfq.bean.Users;
import com.mfq.bean.juxinli.stepTwo.Data;
import com.mfq.bean.juxinli.stepTwo.Datasource;
import com.mfq.constants.AuthStatus;
import com.mfq.constants.Constants;
import com.mfq.constants.OrderStatus;
import com.mfq.service.JuxinliService;
import com.mfq.service.OrderInfoService;
import com.mfq.service.UserService;
import com.mfq.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.HTTP;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhiguo1 on 16/4/17.
 */
@Controller
public class PageController {
    private static final Logger logger = LoggerFactory
            .getLogger(PageController.class);

    @Resource
    OrderInfoService orderInfoService;
    @Resource
    UserService userService;
    @Resource
    JuxinliService juxinliService;

    @RequestMapping(value = {"/apply", "/apply/"}, method = {RequestMethod.GET})
    public String apply(HttpServletRequest request, HttpServletResponse response,Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        OrderInfo orderInfo = orderInfoService.selectLastByUid(uid);
        if(orderInfo != null && orderInfo.getStatus() == OrderStatus.APPLY.getValue()){
            model.addAttribute("msg","您有一个申请中的订单,点击去完善资料.");
            model.addAttribute("link","/base");
        }
        return "apply";
    }

    @RequestMapping(value = {"/apply", "/apply/"}, method = {RequestMethod.POST})
    public String applyInfo(HttpServletRequest request, HttpServletResponse response,
                            Model model,
                            @RequestParam("applyName") String proName,
                            @RequestParam("money") BigDecimal price,
                            @RequestParam("moneyMonth") Integer period) {
        try {
            Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
            orderInfoService.saveOrderInfo(proName, price, period, uid);

        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "apply";
        }
        return "redirect:/base";
    }


    @RequestMapping(value = {"/apply/success", "/apply/success/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String applySuccess(HttpServletRequest request, HttpServletResponse response) {

        return "applySuccess";
    }

    @RequestMapping(value = {"/base", "/base/"}, method = {RequestMethod.GET})
    public String base(HttpServletRequest request, HttpServletResponse response) {
        logger.info("base uid :"+request.getSession().getAttribute("uid"));
        return toWebByUserAuthStatus(Long.parseLong(request.getSession().getAttribute("uid").toString()));
    }

    @RequestMapping(value = {"/base", "/base/"}, method = {RequestMethod.POST})
    public String uploadBase(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("name") String name,
                             @RequestParam("nowNumber") String mobile,
                             @RequestParam("conEcod") String vcode,
                             @RequestParam("idCard") String idcard,
                             @RequestParam("userType") Integer userType,
                             @RequestParam(value = "zhiye",required = false)String zhiye,
                             @RequestParam(value = "zhiwei",required = false)String zhiwei) {


        try {
            long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
            userService.uploadBase(name, mobile, vcode, idcard, userType, uid , zhiye,zhiwei);
            if (userType == 1) {
                return "redirect:/submit/student";
            } else if (userType == 2) {
                return "redirect:/submit/work";
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            model.addAttribute("msg", e.getMessage());
            return "base";
        }
        return "base";
    }

    @RequestMapping(value = {"/confirm", "/confirm/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String confirm(HttpServletRequest request, HttpServletResponse response,
                          Model model) {

        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());

        OrderInfo orderInfo = orderInfoService.selectLastByUid(uid);
        model.addAttribute("status",0);
        if (orderInfo == null) {
            model.addAttribute("msg","您还没有下订单,点击前往补充个人资料");
            model.addAttribute("no","sdf");
            model.addAttribute("link","/base");
        } else {
            Users user = userService.selectByUid(uid);
            if(user.getStatus() == AuthStatus.USERTYPEDETAIL.getId()){
                model.addAttribute("status",1);
            }
            if(user.getStatus() == AuthStatus.USERTAOBAOORJDPASSWORD.getId()){
                model.addAttribute("status",3);
            }

            model.addAttribute("order", orderInfo);
        }
        return "confirm";
    }

    public String toWebByUserAuthStatus(Long uid){
        Users user = userService.selectByUid(uid);

        if(user.getStatus() == AuthStatus.INIT.getId()){
            return "base";
        }

        if(user.getStatus() == AuthStatus.BASE.getId()){
            if(user.getUserType() == 1)
                return "redirect:/submit/student";
            if(user.getUserType() == 2){
                return "redirect:/submit/work";
            }
        }

        if(user.getStatus() == AuthStatus.USERTYPEDETAIL.getId()){
            return "redirect:/home";
        }

        return "redirect:/apply/success";
    }

    @RequestMapping(value = {"/home", "/home/"}, method = {RequestMethod.GET})
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {

            String json = JuxinliService.init();
            JSONObject object = JSON.parseObject(json);

            JSONArray array = object.getJSONArray("data");
            List<Datasource> datasources = new ArrayList<>();


            for (int i = 0; i < array.size(); i++) {
                Datasource datasource = JsonUtil.toBean(array.get(i).toString(), Datasource.class);
                datasources.add(datasource);
            }

            HttpSession session = request.getSession();
            session.setAttribute("datasources", datasources);
            model.addAttribute("datasources", datasources);

        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info(e.getCause().toString());
            e.printStackTrace();
        }
        return "home";
    }

    @RequestMapping(value = {"/home", "/home/"}, method = {RequestMethod.POST})
    public String uploadHome(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("choiced") String choiced
    ) {

        System.out.println(choiced);
        HttpSession session = request.getSession();
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        try {
            List<Datasource> list = (List<Datasource>) request.getSession().getAttribute("datasources");
            List<Datasource> datasources = new ArrayList<>();
            for (Datasource datasource : list) {
                if (choiced.contains("jd") && datasource.getWebsite().equals("jingdong")) {
                    datasources.add(datasource);
                    continue;
                }
                if (choiced.contains("taobao") && datasource.getWebsite().equals("taobao")) {
                    datasources.add(datasource);
                    continue;
                }
            }

            JSONObject resp = JSON.parseObject(juxinliService.oneStep(uid, datasources));
            Data data = JsonUtil.toBean(JsonUtil.writeToJson(resp.get("data")), Data.class);

            session.setAttribute("choiced", choiced);
            session.setAttribute("token", data.getToken());
            session.setAttribute("twoStepData", data);

        } catch (Exception e) {
            logger.info(e.getMessage());
            model.addAttribute("msg", e.getMessage());
            return "home";
        }

        return "redirect:/home/two";
    }

    @RequestMapping(value = {"/home/two", "/home/two/"}, method = {RequestMethod.GET})
    public String homeTwo(HttpServletRequest request, HttpServletResponse response, Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());

        model.addAttribute("user", userService.selectByUid(uid));
        return "homeTwo";
    }

    @RequestMapping(value = {"/home/two", "/home/two/"}, method = {RequestMethod.POST})
    public String uplaodHomeTwo(HttpServletRequest request, HttpServletResponse response, Model model,
                                @RequestParam(value = "serverPwd", required = true) String serverPwd
    ) {

        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        try {
            userService.uploadServerPwd(uid,serverPwd);
            juxinliService.twoStep(uid, (Data) request.getSession().getAttribute("twoStepData"),
                    serverPwd, request.getSession());
            request.getSession().setAttribute("serverPwd", serverPwd);

        } catch (Exception e) {
            logger.error(e.getMessage());
            model.addAttribute("user", userService.selectByUid(uid));
            model.addAttribute("msg",e.getMessage());
            return "homeTwo";
        }

        return "redirect:/home/two/two";
    }

    @RequestMapping(value = {"/home/two/two", "/home/two/two/"}, method = {RequestMethod.GET})
    public String homeTwoTwo(HttpServletRequest request, HttpServletResponse response, Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());

        model.addAttribute("user", userService.selectByUid(uid));
        model.addAttribute("serverPwd", request.getSession().getAttribute("serverPwd"));
        return "homeTwoTwo";
    }

    @RequestMapping(value = {"/home/two/two", "/home/two/two/"}, method = {RequestMethod.POST})
    public String homeTwoTwoPost(HttpServletRequest request, HttpServletResponse response, Model model,
                                 @RequestParam("dongtaiPwd") String dongtaiPwd) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());

        try {
            HttpSession session = request.getSession();

            String serverPwd = (String) request.getSession().getAttribute("serverPwd");
            juxinliService.threeStep(uid, (Data) request.getSession().getAttribute("twoStepData"),
                    serverPwd, dongtaiPwd, (String) request.getSession().getAttribute("type"), session);


        } catch (Exception e) {
            logger.error(e.getMessage());

        }


        return "redirect:/home/three";
    }

    @RequestMapping(value = {"/home/three", "/home/three/"}, method = {RequestMethod.GET})
    public String homeThree(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Datasource datasource = (Datasource) session.getAttribute("nextDatasource");
        if (datasource.getWebsite().equals("jingdong")) {
            return "homeThree-jd";
        } else if (datasource.getWebsite().equals("taobao")) {
            return "homeThree-taobao";
        }
        return null;
    }

    @RequestMapping(value = {"/home/three", "/home/three/"}, method = {RequestMethod.POST})
    public String homeThreePost(HttpServletRequest request, HttpServletResponse response, Model model,
                                @RequestParam(value = "taobao", required = false) String taobao,
                                @RequestParam(value = "taobaoPwd", required = false) String taobaoPwd,
                                @RequestParam(value = "jd", required = false) String jd,
                                @RequestParam(value = "jdPwd", required = false) String jdPwd) {
        HttpSession session = request.getSession();
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());

        try {

            if (StringUtils.isNotBlank(taobao) && StringUtils.isNotBlank(taobaoPwd)) {
                userService.uploadTaobao(taobao,taobaoPwd,uid);
                juxinliService.fourStep(uid, (Data) request.getSession().getAttribute("twoStepData"),
                        taobaoPwd, session.getAttribute("captcha").toString(),  taobao, (String) request.getSession().getAttribute("type"),session);
            } else if (StringUtils.isNotBlank(jd) && StringUtils.isNotBlank(jdPwd)) {
                userService.uploadJd(taobao,taobaoPwd,uid);
                juxinliService.fourStep(uid, (Data) request.getSession().getAttribute("twoStepData"),
                        jdPwd, session.getAttribute("captcha").toString(),  jd, (String) request.getSession().getAttribute("type"),session);
            } else {
                return "redirect:/home/three";
            }

            if((boolean)session.getAttribute("finish") == false){
                return "redirect:/home/three";
            }else{
                return "redirect:/apply/success";
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            model.addAttribute("msg", e.getMessage());

            Datasource datasource = (Datasource) session.getAttribute("nextDatasource");
            if (datasource.getWebsite().equals("jingdong")) {
                return "homeThree-jd";
            } else if (datasource.getWebsite().equals("taobao")) {
                return "homeThree-taobao";
            }
        }

        return null;
    }

    @RequestMapping(value = {"/home/resetServerPwd", "/home/resetServerPwd/"}, method = {RequestMethod.POST})
    public String resetServerPwd(HttpServletRequest request, HttpServletResponse response, Model model) {


        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        try {


        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "redirect:/home/three";
        }
        return "homeFour";
    }

    @RequestMapping(value = {"/home/four", "/home/four/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String homeFour(HttpServletRequest request, HttpServletResponse response) {

        return "homeFour";
    }

    @RequestMapping(value = {"/submit/student", "/submit/student/"}, method = {RequestMethod.GET})
    public String submitStudent(HttpServletRequest request, HttpServletResponse response) {

        return "submitStudent";
    }

    @RequestMapping(value = {"/submit/student", "/submit/student/"}, method = {RequestMethod.POST})
    public String uploadStudent(HttpServletRequest request, HttpServletResponse response, Model model,
                                @RequestParam("idFace") MultipartFile idFront,
                                @RequestParam("idReturn") MultipartFile idBack,
                                @RequestParam("studentCard") MultipartFile studentId,
                                @RequestParam("studentSelf") MultipartFile cardIdWithHand,
                                @RequestParam("xuexinwang") MultipartFile xuexinwang,
                                @RequestParam("schoolPro") String schoolPro,
                                @RequestParam("schoolCity") String schoolCity,
                                @RequestParam("schoolName") String schoolName,
                                @RequestParam("schoolClass") String grade,
                                @RequestParam("qqNumber") String qq,
                                @RequestParam("address") String address,
                                @RequestParam("parents") String parents,
                                @RequestParam("parentsPhone") String parentsPhone,
                                @RequestParam(value = "wechat",required = false,defaultValue = "") String wechat,
                                @RequestParam("level") String level,
                                @RequestParam("salary") String salary
    ) {
        try {

            if (idFront.isEmpty() || idBack.isEmpty() || studentId.isEmpty() || cardIdWithHand.isEmpty()) {
                throw new Exception("照片数量有误");
            }
            String idFrontUrl = "";
            if (!idFront.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                idFront.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                idFrontUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String idBackUrl = "";
            if (!idBack.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                idBack.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                idBackUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String studentIdUrl = "";
            if (!studentId.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                studentId.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                studentIdUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String cardIdWithHandUrl = "";
            if (!cardIdWithHand.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                cardIdWithHand.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                cardIdWithHandUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String xuexinwangUrl = "";
            if (!xuexinwang.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                xuexinwang.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                xuexinwangUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }

            Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
            userService.uploadStudent(idFrontUrl, idBackUrl, studentIdUrl, cardIdWithHandUrl,schoolPro, schoolCity, schoolName,
                    grade, qq, address, parents, parentsPhone, wechat, uid, xuexinwangUrl,level,salary);


        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "submitStudent";
        }

        return "redirect:/home";
    }

    @RequestMapping(value = {"/submit/work", "/submit/work/"}, method = {RequestMethod.GET})
    public String submitWork(HttpServletRequest request, HttpServletResponse response) {

        return "submitWork";
    }


    @RequestMapping(value = {"/submit/work", "/submit/work/"}, method = {RequestMethod.POST})
    public String uploadWork(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("face") MultipartFile idFront,
                             @RequestParam("return") MultipartFile idBack,
                             @RequestParam("nameCard") MultipartFile nameCard,
                             @RequestParam("self") MultipartFile self,
                             @RequestParam("work") String work,
                             @RequestParam("workAddress") String workAddress,
                             @RequestParam("liveAddress") String liveAddress,
                             @RequestParam("monthAccess") String monthAccess,
                             @RequestParam("level") String level,
                             @RequestParam("email") String email,
                             @RequestParam("friend") String friend,
                             @RequestParam("friendPhone") String friendPhone,
                             @RequestParam(value = "card",required = false,defaultValue = "") String card ){
        try {

            if (idFront.isEmpty() || idBack.isEmpty() || nameCard.isEmpty() || self.isEmpty()) {
                throw new Exception("照片数量有误");
            }
            String idFrontUrl = "";
            if (!idFront.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                idFront.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                idFrontUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String idBackUrl = "";
            if (!idBack.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                idBack.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                idBackUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String nameCardUrl = "";
            if (!nameCard.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                nameCard.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                nameCardUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            String selfUrl = "";
            if (!self.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                self.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                selfUrl = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }

            Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
            userService.uploadWork(idFrontUrl, idBackUrl, nameCardUrl, selfUrl, work, level, email,
                    friend, friendPhone, card, uid,workAddress,liveAddress,monthAccess);


        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "submitWork";
        }

        return "redirect:/home";
    }

    @RequestMapping(value = {"/chooseWeb", "/chooseWeb/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String chooseWeb(HttpServletRequest request, HttpServletResponse response) {

        Integer type = Integer.parseInt(request.getParameter("type").toString());
        HttpSession session = request.getSession();
        session.setAttribute("choose", type);
        return JsonUtil.successResultJson();
    }


    @RequestMapping(value = {"/my", "/my/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String my(HttpServletRequest request, HttpServletResponse response, Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        orderInfoService.myPage(uid, model);
        return "my";
    }

    @RequestMapping(value = {"/allPay", "/allPay/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String allPay(HttpServletRequest request, HttpServletResponse response, Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        orderInfoService.allPayPage(uid, model);
        return "allPay";
    }

    @RequestMapping(value = {"/month", "/month/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String month(HttpServletRequest request, HttpServletResponse response, Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        orderInfoService.monthPage(uid, model);
        return "month";
    }

    @RequestMapping(value = {"/my/all", "/my/all/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String myAll(HttpServletRequest request, HttpServletResponse response, Model model) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        orderInfoService.myAllPage(uid, model);
        return "myAll";
    }

    @RequestMapping(value = {"/my/all/{orderNo}", "/my/all/{orderNo}/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String allByOrder(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String orderNo) {
        Long uid = Long.parseLong(request.getSession().getAttribute("uid").toString());
        if (StringUtils.isNotEmpty(orderNo)) {
            orderInfoService.myAllBills(uid, orderNo, model);
        }
        return "allbyorder";
    }

    @RequestMapping(value = {"/record", "/record/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String record(HttpServletRequest request, HttpServletResponse response) {

        return "record";
    }

    @RequestMapping(value = {"/step", "/step/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String step(HttpServletRequest request, HttpServletResponse response) {

        return "step";
    }


    /**
     * 借款协议
     */
    @RequestMapping("/jiekuanxieyi")
    public String jiekuanxieyi(HttpServletRequest request,Model model){
        model.addAttribute("username",userService.selectByUid(Long.parseLong(request.getSession().getAttribute("uid").toString())));
        return "jiekuanxieyi";
    }
    /**
     * 声明
     */
    @RequestMapping("/shengming")
    public String shengming(){
        return "shengming";
    }


}
