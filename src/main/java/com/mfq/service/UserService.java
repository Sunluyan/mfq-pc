package com.mfq.service;

import com.alibaba.fastjson.JSONObject;
import com.mfq.bean.*;
import com.mfq.bean.wechat.OpenId;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    @Resource
    OpenidUidMapper openidUidMapper;

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

    @Transactional
    public void updateUserStatus(long uid , AuthStatus status) throws Exception{
        Users user = new Users();
        user.setStatus(status.getId());
        user.setUid(uid);
        long count = mapper.updateByPrimaryKeySelective(user);
        if(count!=1){
            throw new RuntimeException("更新用户状态出错");
        }
    }

    /**
     * 根据用户状态和订单 决定用户去哪个网页
     * @param uid
     * @return
     */


    /**
     * 上传上班族用户信息
     * @param idFrontUrl
     * @param idBackUrl
     * @param nameCardUrl
     * @param selfUrl
     * @param work
     * @param level
     * @param email
     * @param friend
     * @param friendPhone
     * @param card
     * @param uid
     */
    @Transactional
    public void uploadWork(String idFrontUrl, String idBackUrl, String nameCardUrl, String selfUrl, String work,
                           String level, String email, String friend, String friendPhone,
                           String card, Long uid) throws Exception{

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

        long count = 0;
        if(list != null && list.size() != 0){
            count = workInfoMapper.updateByPrimaryKeySelective(info);
        }else{
            count = workInfoMapper.insertSelective(info);
        }
        if(count != 1){
            throw new RuntimeException("上传用户资料出错");
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

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
        UserService service = ac.getBean(UserService.class);
        OpenId openId = new OpenId();
        openId.setOpenid("aaaaaaaaaaaaaaaaaaaaa");
        service.selectOrInsertByOpenid(openId,null);
    }

    /**
     * 查询或新建用户,并放入 session 中 (暂时)
     * @param openId
     * @param session
     * @throws Exception
     */
    @Transactional
    public void selectOrInsertByOpenid(OpenId openId,HttpSession session) throws Exception{
        OpenidUid openidUid = openidUidMapper.selectByPrimaryKey(openId.getOpenid());
        if(openidUid == null){
            //创建新用户
            Users user = new Users();
            user.setUpdatedAt(new Date());
            long count = mapper.insertSelective(user);
            if(count <= 0 ){
                throw new RuntimeException("插入用户错误,请重试");
            }
            openidUid = new OpenidUid();
            openidUid.setOpenid(openId.getOpenid());
            openidUid.setUid(user.getUid());
            count = openidUidMapper.insert(openidUid);
            if(count <= 0 ){
                throw new RuntimeException("插入错误,请重试");
            }
            session.setAttribute("openid",openidUid.getOpenid());
            session.setAttribute("uid",user.getUid());

        }else{
            session.setAttribute("openid",openidUid.getOpenid());
            session.setAttribute("uid",openidUid.getUid());
        }
    }
}
