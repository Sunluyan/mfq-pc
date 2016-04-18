package com.mfq.controller;

import com.mfq.service.OrderInfoService;
import com.mfq.utils.AliyunFile;
import com.mfq.utils.FileTypeTest;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.RandomUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by liuzhiguo1 on 16/4/17.
 */
@Controller
public class PageController {
    private static final Logger logger = LoggerFactory
            .getLogger(PageController.class);

    @Resource
    OrderInfoService service;

    @RequestMapping(value = {"/apply", "/apply/"}, method = {RequestMethod.GET})
    public String apply(HttpServletRequest request, HttpServletResponse response) {

        return "apply";
    }

    @RequestMapping(value = {"/apply", "/apply/"}, method = {RequestMethod.POST})
    public String applyInfo(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam("applyName") String proName,
                            @RequestParam("money") BigDecimal price,
                            @RequestParam("moneyMonth") Integer period,
                            @RequestParam("upLoad") MultipartFile img
    ) {
        try {

            String url = "";
            if (!img.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                img.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                url = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
            }
            Long uid = 9527l;
            service.saveOrderInfo(proName,price,period,url,uid);


        }catch(Exception e){
            logger.error(e.toString());
            return "apply";
        }

        return "applySuccess";
    }

    @RequestMapping(value = {"/allPay", "/allPay/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String allPay(HttpServletRequest request, HttpServletResponse response) {

        return "allPay";
    }

    @RequestMapping(value = {"/apply/success", "/apply/success/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String applySuccess(HttpServletRequest request, HttpServletResponse response) {

        return "applySuccess";
    }

    @RequestMapping(value = {"/base", "/base/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String base(HttpServletRequest request, HttpServletResponse response) {

        return "base";
    }

    @RequestMapping(value = {"/confirm", "/confirm/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String confirm(HttpServletRequest request, HttpServletResponse response) {

        return "confirm";
    }

    @RequestMapping(value = {"/home", "/home/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home(HttpServletRequest request, HttpServletResponse response) {

        return "home";
    }

    @RequestMapping(value = {"/home/four", "/home/four/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String homeFour(HttpServletRequest request, HttpServletResponse response) {

        return "homeFour";
    }

    @RequestMapping(value = {"/home/three", "/home/three/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String homeThree(HttpServletRequest request, HttpServletResponse response) {

        return "homeThree";
    }

    @RequestMapping(value = {"/month", "/month/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String month(HttpServletRequest request, HttpServletResponse response) {

        return "month";
    }

    @RequestMapping(value = {"/my", "/my/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String my(HttpServletRequest request, HttpServletResponse response) {

        return "my";
    }

    @RequestMapping(value = {"/my/all", "/my/all/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String myAll(HttpServletRequest request, HttpServletResponse response) {

        return "myAll";
    }

    @RequestMapping(value = {"/record", "/record/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String record(HttpServletRequest request, HttpServletResponse response) {

        return "record";
    }

    @RequestMapping(value = {"/step", "/step/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String step(HttpServletRequest request, HttpServletResponse response) {

        return "step";
    }

    @RequestMapping(value = {"/submit/student", "/submit/student/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String submitStudent(HttpServletRequest request, HttpServletResponse response) {

        return "submitStudent";
    }

    @RequestMapping(value = {"/submit/work", "/submit/work/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String submitWork(HttpServletRequest request, HttpServletResponse response) {

        return "submitWork";
    }


}
