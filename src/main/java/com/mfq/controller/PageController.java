package com.mfq.controller;

import com.mfq.bean.OrderInfo;
import com.mfq.service.OrderInfoService;
import com.mfq.service.UserService;
import com.mfq.utils.AliyunFile;
import com.mfq.utils.FileTypeTest;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.RandomUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    OrderInfoService orderInfoService;
    @Resource
    UserService userService;

    @RequestMapping(value = {"/apply", "/apply/"}, method = {RequestMethod.GET})
    public String apply(HttpServletRequest request, HttpServletResponse response) {

        Long uid = 9527l;


        return userService.toWebByUserAuthStatus(uid);
    }

    @RequestMapping(value = {"/apply", "/apply/"}, method = {RequestMethod.POST})
    public String applyInfo(HttpServletRequest request, HttpServletResponse response,
                            Model model,
                            @RequestParam("applyName") String proName,
                            @RequestParam("money") BigDecimal price,
                            @RequestParam("moneyMonth") Integer period,
                            @RequestParam("upLoad") MultipartFile img) {
        try {
            String url = "";
            if (!img.isEmpty()) {
                File tmpFile = new File(System.currentTimeMillis() + RandomUtil.getRandom(5));
                img.transferTo(tmpFile);
                AliyunFile.uploadFile("wxp", tmpFile, tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile));
                url = "http://y.iyeeda.com/" + tmpFile.getName() + "." + FileTypeTest.getFileByFile(tmpFile);
                tmpFile.delete();
            }
            Long uid = 9527l;
            orderInfoService.saveOrderInfo(proName, price, period, url, uid);


        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "apply";
        }

        return "base";
    }

    @RequestMapping(value = {"/allPay", "/allPay/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String allPay(HttpServletRequest request, HttpServletResponse response) {

        return "allPay";
    }

    @RequestMapping(value = {"/apply/success", "/apply/success/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String applySuccess(HttpServletRequest request, HttpServletResponse response) {

        return "applySuccess";
    }

    @RequestMapping(value = {"/base", "/base/"}, method = {RequestMethod.GET})
    public String base(HttpServletRequest request, HttpServletResponse response) {

        return "base";
    }

    @RequestMapping(value = {"/base", "/base/"}, method = {RequestMethod.POST})
    public String uploadBase(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("name") String name,
                             @RequestParam("nowNumber") String mobile,
                             @RequestParam("conEcod") String vcode,
                             @RequestParam("idCard") String idcard,
                             @RequestParam("userType") Integer userType) {


        try {
            long uid = 9527;
            userService.uploadBase(name, mobile, vcode, idcard, userType, uid);
            if (userType == 1) {
                return "redirect:/submitStudent";
            } else if (userType == 2) {
                return "redirect:/submitWork";
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
        Long uid = 9527l;
        OrderInfo orderInfo = orderInfoService.selectLastByUid(uid);
        if (orderInfo == null) {

        } else {
            model.addAttribute("order", orderInfo);
        }
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
                                @RequestParam("schoolPro") String schoolPro,
                                @RequestParam("schoolCity") String schoolCity,
                                @RequestParam("schoolName") String schoolName,
                                @RequestParam("schoolClass") String grade,
                                @RequestParam("qqNumber") String qq,
                                @RequestParam("address") String address,
                                @RequestParam("parents") String parents,
                                @RequestParam("parentsPhone") String parentsPhone,
                                @RequestParam("webChat") String wechat
    ) {
        try {

            if(idFront.isEmpty() || idBack.isEmpty() || studentId.isEmpty() || cardIdWithHand.isEmpty()){
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

            Long uid = 9527l;
            userService.uploadStudent(idFrontUrl,idBackUrl,studentIdUrl,cardIdWithHandUrl,schoolPro,schoolCity,schoolName,
                    grade,qq,address,parents,parentsPhone,wechat,uid);


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
    public String uploadWork(HttpServletRequest request, HttpServletResponse response,Model model,
                             @RequestParam("face") MultipartFile idFront,
                             @RequestParam("return") MultipartFile idBack,
                             @RequestParam("nameCard") MultipartFile nameCard,
                             @RequestParam("self") MultipartFile self,
                             @RequestParam("work") String work,
                             @RequestParam("level") String level,
                             @RequestParam("email") String email,
                             @RequestParam("friend") String friend,
                             @RequestParam("friendPhone") String friendPhone,
                             @RequestParam("card") String card) {
        try {

            if(idFront.isEmpty() || idBack.isEmpty() || nameCard.isEmpty() || self.isEmpty()){
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

            /**
             * @RequestParam("work") String work,
             @RequestParam("level") String level,
             @RequestParam("email") String email,
             @RequestParam("friend") String friend,
             @RequestParam("friendPhone") String friendPhone,
             @RequestParam("card") String card)
             */
            Long uid = 9527l;
            userService.uploadWork(idFrontUrl,idBackUrl,nameCardUrl,selfUrl,work,level,email,
                    friend,friendPhone,card,uid);


        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "submitWork";
        }

        return "redirect:/home";
    }


}
