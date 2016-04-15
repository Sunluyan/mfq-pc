package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.wechat.WeChatMsg;
import org.springframework.stereotype.Component;

@MFQDao
@Component
public interface WeChatMsgMapper {

    public Long saveWeChatMsg(WeChatMsg msg);
}
