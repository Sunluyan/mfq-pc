package com.mfq.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import com.mfq.bean.VcodeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mfq.bean.CodeMsg;
import com.mfq.bean.Vcode;
import com.mfq.constants.ErrorCodes;
import com.mfq.dao.VcodeMapper;
import com.mfq.utils.DateUtil;

@Service
public class VcodeService {
    
    private static final Logger logger = LoggerFactory.getLogger(VcodeService.class);

    @Resource
    VcodeMapper mapper;
    
    private static final int LIMIT = 5;
    
    /**
     * 验证码确认
     * 
     * @param key
     *            要验证的手机号或者邮箱
     * @param vcode
     *            要验证的code
     * @return 验证的结果
     */
    public CodeMsg validate(String key, String vcode){
        Vcode vcodeBean = queryVcode(key);
        if (vcodeBean.getId() == 0) {
            return new CodeMsg(ErrorCodes.USER_VCODE_WRONG, "验证内容不存在");
        }
        if (vcodeBean.getRetryTime() > LIMIT) {
            return new CodeMsg(ErrorCodes.USER_VCODE_TOOMUCH, "验证码验证次数过多");
        } else if (DateUtil.getDayBetweenD(new Date(), vcodeBean.getExpireAt()) < 0) {
            return new CodeMsg(ErrorCodes.USER_VCODE_EXPIRED, "验证码过期");

        } else if (!vcodeBean.getVcode().equals(vcode)) {

            return new CodeMsg(ErrorCodes.USER_VCODE_WRONG, "验证码不匹配");
        }
        return new CodeMsg(ErrorCodes.SUCCESS, "验证成功");
    }

    /**
     * 查询当前验证码
     * 
     * @param key
     * @return 验证码信息或者空Vcode(id=0)
     */
    public Vcode queryVcode(String key){
        VcodeExample example = new VcodeExample();
        example.or().andEmkeyEqualTo(key);
        List<Vcode> list  = mapper.selectByExample(example);
        if(list == null || list.size() == 0){
            Vcode vcode = new Vcode();
            vcode.setEmkey("");
            return vcode;
        }
        return list.get(0);

    }

    /**
     * 请求生成一个新的验证码
     * 
     * @param key
     *            要验证的手机号或者邮箱
     * @param expireAt
     *            过期时间
     * @param resendAt
     *            重发时间
     * @return 验证码信息
     */
    public Vcode applyVcode(String key, Date expireAt, Date resendAt){
     // 申请一个新的验证码
        Vcode vcode = queryVcode(key);
        try{
            String code = createNewCode();
            if (vcode.getId() == null || vcode.getId() == 0) {
                vcode.setEmkey(key);
                vcode.setVcode(code);
                vcode.setExpireAt(expireAt);
                vcode.setResendAt(resendAt);
                mapper.insertSelective(vcode);
            } else {
                if (DateUtil.getDayBetweenD(expireAt, vcode.getExpireAt()) > 0 && vcode.getRetryTime() < LIMIT) {
                    // 此时验证码依然有效
                    return vcode;
                }
                vcode.setVcode(code);
                vcode.setExpireAt(expireAt);
                vcode.setResendAt(resendAt);
                vcode.setUpdatedAt(new Date());
                VcodeExample example = new VcodeExample();
                example.or().andEmkeyEqualTo(vcode.getEmkey());
                mapper.updateByExampleSelective(vcode,example);
            }
            vcode = queryVcode(key);
        }catch(Exception e){
            logger.error("APPLY_VCODE_EXCEPTION", e);
        }
        return vcode;
    }
    
    private String createNewCode() {
        Random random = new Random();
        return (random.nextInt(9000) + 1000) + "";
    }
}
