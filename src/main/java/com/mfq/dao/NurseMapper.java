package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.user.Nurse;

import java.util.List;

@MFQDao
public interface NurseMapper {

    int deleteByPrimaryKey(Integer nurseNumber);

    int insert(Nurse record);

    int insertSelective(Nurse record);

    Nurse selectByPrimaryKey(Integer nurseNumber);

    int updateByPrimaryKeySelective(Nurse record);

    int updateByPrimaryKey(Nurse record);
    
    List<Nurse> selectAll();
}