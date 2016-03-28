package com.mfq.dao;

import com.mfq.bean.InviteMoney;
import com.mfq.bean.InviteMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InviteMoneyMapper {
    int countByExample(InviteMoneyExample example);

    int deleteByExample(InviteMoneyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InviteMoney record);

    int insertSelective(InviteMoney record);

    List<InviteMoney> selectByExample(InviteMoneyExample example);

    InviteMoney selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InviteMoney record, @Param("example") InviteMoneyExample example);

    int updateByExample(@Param("record") InviteMoney record, @Param("example") InviteMoneyExample example);

    int updateByPrimaryKeySelective(InviteMoney record);

    int updateByPrimaryKey(InviteMoney record);
}