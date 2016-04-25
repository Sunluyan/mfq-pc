package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.WechatEvent;
import com.mfq.bean.WechatEventExample;
import com.mfq.bean.WechatEventWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@MFQDao
@Component

public interface WechatEventMapper {
    int countByExample(WechatEventExample example);

    int deleteByExample(WechatEventExample example);

    int deleteByPrimaryKey(Integer eventId);

    int insert(WechatEventWithBLOBs record);

    int insertSelective(WechatEventWithBLOBs record);

    List<WechatEventWithBLOBs> selectByExampleWithBLOBs(WechatEventExample example);

    List<WechatEvent> selectByExample(WechatEventExample example);

    WechatEventWithBLOBs selectByPrimaryKey(Integer eventId);

    int updateByExampleSelective(@Param("record") WechatEventWithBLOBs record, @Param("example") WechatEventExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatEventWithBLOBs record, @Param("example") WechatEventExample example);

    int updateByExample(@Param("record") WechatEvent record, @Param("example") WechatEventExample example);

    int updateByPrimaryKeySelective(WechatEventWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WechatEventWithBLOBs record);

    int updateByPrimaryKey(WechatEvent record);
}