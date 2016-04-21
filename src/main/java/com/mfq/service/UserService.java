package com.mfq.service;

import com.alibaba.fastjson.JSONObject;
import com.mfq.bean.*;
import com.mfq.constants.AuthStatus;
import com.mfq.constants.Constants;
import com.mfq.constants.ErrorCodes;
import com.mfq.controller.VcodeController;
import com.mfq.dao.*;
import com.mfq.helper.MobileHelper;
import com.mfq.utils.HttpUtil;
import com.mfq.utils.IDCardUtil;
import com.mfq.utils.JsonUtil;
import com.mfq.utils.VerifyUtils;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by liuzhiguo1 on 16/4/18.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory
            .getLogger(UserService.class);

    @Resource
    UsersMapper mapper;
    @Resource
    VcodeService vcodeService;
    @Resource
    StudentInfoMapper studentInfoMapper;
    @Resource
    OrderInfoService orderInfoService;
    @Resource
    WorkInfoMapper workInfoMapper;
    @Resource
    JuxinliMapper juxinliMapper;

    public Users selectByUid(Long uid ){
        return mapper.selectByPrimaryKey(uid);
    }

    @Transactional
    public void uploadBase(String name,String mobile,String vcode,String idCard,Integer userType,Long uid) throws Exception {
        //验证开始

        if(vcodeService.validate(mobile,vcode).getCode() != ErrorCodes.SUCCESS){
            throw new Exception("验证码错误");
        }
        String idCardIsRight = IDCardUtil.IDCardValidate(idCard);
        if (!idCardIsRight.equals("")) {
            throw new Exception("身份证格式错误");
        }
        JSONObject ret = CheckIDCard(name.trim(), idCard);
        int retcode = ret.getInteger("code");
        if (retcode == 1) {
            //正确
        } else if (retcode == 2) {
            throw new Exception("身份证校验不一致");
        } else if (retcode == 3) {
            throw new Exception("无此身份证号");
        } else if (retcode == 12) {
            throw new Exception("余额不足");
        } else {
            throw new Exception("身份证校验错误");
        }

        if (!VerifyUtils.verifyMobile(mobile)) {
            throw new Exception("手机号格式错误");
        }

        //验证结束
        Users user = mapper.selectByPrimaryKey(uid);
        user.setRealname(name);
        user.setMobile(mobile);
        user.setUserType(userType);
        user.setCardId(idCard);
        user.setUpdatedAt(new Date());
        user.setStatus(AuthStatus.BASE.getId());
        mapper.updateByPrimaryKeySelective(user);
    }

    public JSONObject CheckIDCard(String name, String idcard) {
        String url = Constants.IDCARD_CHECK.replace("APPKEY", Constants.IDCARD_APPKEY).replace("NAME", name)
                .replace("IDCARD", idcard);
        String result = HttpUtil.get(url, false);
        return JSONObject.parseObject(result);
    }

    @Transactional
    public void uploadStudent(String idFrontUrl, String idBackUrl, String studentIdUrl, String cardIdWithHandUrl, String schoolPro,
                              String schoolCity, String schoolName, String grade, String qq, String address, String parents,
                              String parentsPhone, String wechat,Long uid) throws Exception{
        StudentInfo info = new StudentInfo();

        StudentInfoExample example = new StudentInfoExample();
        example.or().andUidEqualTo(uid);
        List<StudentInfo> list =  studentInfoMapper.selectByExample(example);

        if(list != null && list.size() != 0){
            info = list.get(0);
        }
        info.setUid(uid);
        info.setIdFront(idFrontUrl);
        info.setIdBack(idBackUrl);
        info.setStudentId(studentIdUrl);
        info.setIdWithHand(cardIdWithHandUrl);
        info.setSchoolProvice(schoolPro);
        info.setSchoolCity(schoolCity);
        info.setSchoolName(schoolName);
        info.setGrade(grade);
        info.setQq(qq);
        info.setHomeAddress(address);
        info.setFamilyName(parents);
        info.setFamilyMobile(parentsPhone);
        info.setWechatNo(wechat);
        info.setUpdatedAt(new Date());

        if(list != null && list.size() != 0){
            studentInfoMapper.updateByPrimaryKeySelective(info);
        }else{
            studentInfoMapper.insertSelective(info);
        }
        updateUserStatus(uid,AuthStatus.USERTYPEDETAIL);
    }

    public void updateUserStatus(long uid , AuthStatus status){
        Users user = new Users();
        user.setStatus(status.getId());
        user.setUid(uid);
        mapper.updateByPrimaryKeySelective(user);
    }

    public String toWebByUserAuthStatus(Long uid){
        Users user = mapper.selectByPrimaryKey(uid);
        OrderInfo order= orderInfoService.selectLastByUid(uid);

        if(order == null){
            return "apply";
        }
        if(user.getStatus() == AuthStatus.INIT.getId()){
            return "redirect:/base";
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

    public void uploadWork(String idFrontUrl, String idBackUrl, String nameCardUrl, String selfUrl, String work,
                           String level, String email, String friend, String friendPhone,
                           String card, Long uid) {

        WorkInfo info = new WorkInfo();

        WorkInfoExample example = new WorkInfoExample();
        example.or().andUidEqualTo(uid);
        List<WorkInfo> list =  workInfoMapper.selectByExample(example);

        if(list != null && list.size() != 0){
            info = list.get(0);
        }
        info.setUid(uid);
        info.setIdFront(idFrontUrl);
        info.setIdBack(idBackUrl);
        info.setVisitingCard(nameCardUrl);
        info.setIdWithHand(selfUrl);
        info.setCompany(work);
        info.setAcademicBackground(level);
        info.setEmail(email);
        info.setBankCard(card);
        info.setFamilyName(friend);
        info.setFamilyMobile(friendPhone);
        info.setUpdatedAt(new Date());

        if(list != null && list.size() != 0){
            workInfoMapper.updateByPrimaryKeySelective(info);
        }else{
            workInfoMapper.insertSelective(info);
        }
        updateUserStatus(uid,AuthStatus.USERTYPEDETAIL);

    }
    @Transactional
    public void uploadServerPwd(Long uid, String mobilePassword) throws Exception{
        Users user = selectByUid(uid);
        Juxinli record = new Juxinli();
        record.setUid(uid);
        record.setMobile(user.getMobile());
        record.setMobilePassword(mobilePassword);
        record.setUpdatedAt(new Date());
        JuxinliExample example = new JuxinliExample();
        example.or().andUidEqualTo(uid);
        List<Juxinli> list = juxinliMapper.selectByExample(example);
        if (list != null && list.size() != 0) {
            juxinliMapper.updateByExampleSelective(record,example);
        }else{
            juxinliMapper.insertSelective(record);
        }
        updateUserStatus(uid,AuthStatus.USERSERVERPASSWORD);
    }

    @Transactional
    public void uploadTaobao(String taobao, String taobaoPwd, Long uid) throws Exception{
        Users user = selectByUid(uid);
        Juxinli record = new Juxinli();
        record.setUid(uid);
        record.setTaobao(taobao);
        record.setTaobaoPassword(taobaoPwd);
        record.setUpdatedAt(new Date());
        JuxinliExample example = new JuxinliExample();
        example.or().andUidEqualTo(uid);
        List<Juxinli> list = juxinliMapper.selectByExample(example);
        if (list != null && list.size() != 0) {
            juxinliMapper.updateByExampleSelective(record,example);
        }else{
            juxinliMapper.insertSelective(record);
        }
        updateUserStatus(uid,AuthStatus.USERTAOBAOORJDPASSWORD);
    }

    @Transactional
    public void uploadJd(String jd, String jdPwd, Long uid) throws Exception{
        Users user = selectByUid(uid);
        Juxinli record = new Juxinli();
        record.setUid(uid);
        record.setJd(jd);
        record.setJdPassword(jdPwd);
        record.setUpdatedAt(new Date());
        JuxinliExample example = new JuxinliExample();
        example.or().andUidEqualTo(uid);
        List<Juxinli> list = juxinliMapper.selectByExample(example);
        if (list != null && list.size() != 0) {
            juxinliMapper.updateByExampleSelective(record,example);
        }else{
            juxinliMapper.insertSelective(record);
        }

        updateUserStatus(uid,AuthStatus.USERTAOBAOORJDPASSWORD);
    }
}
