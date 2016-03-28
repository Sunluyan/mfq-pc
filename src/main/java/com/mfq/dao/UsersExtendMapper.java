package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.UserExtend;
import com.mfq.bean.example.UsersExtendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface UsersExtendMapper {
    int countByExample(UsersExtendExample example);

    int deleteByExample(UsersExtendExample example);

    int insert(UserExtend record);

    int insertSelective(UserExtend record);

    List<UserExtend> selectByExample(UsersExtendExample example);

    int updateByExampleSelective(@Param("record") UserExtend record, @Param("example") UsersExtendExample example);

    int updateByExample(@Param("record") UserExtend record, @Param("example") UsersExtendExample example);
}