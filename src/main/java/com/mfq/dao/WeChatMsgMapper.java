package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.WechatMsg;
import com.mfq.bean.example.WechatMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface WeChatMsgMapper {
    int countByExample(WechatMsgExample example);

    int deleteByExample(WechatMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatMsg record);

    int insertSelective(WechatMsg record);

    List<WechatMsg> selectByExample(WechatMsgExample example);

    WechatMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatMsg record, @Param("example") WechatMsgExample example);

    int updateByExample(@Param("record") WechatMsg record, @Param("example") WechatMsgExample example);

    int updateByPrimaryKeySelective(WechatMsg record);

    int updateByPrimaryKey(WechatMsg record);
}