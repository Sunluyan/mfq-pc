package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.Nurse;
import com.mfq.bean.example.NurseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface NurseMapper {
    int countByExample(NurseExample example);

    int deleteByExample(NurseExample example);

    int deleteByPrimaryKey(Integer nurseNumber);

    int insert(Nurse record);

    int insertSelective(Nurse record);

    List<Nurse> selectByExample(NurseExample example);

    Nurse selectByPrimaryKey(Integer nurseNumber);

    int updateByExampleSelective(@Param("record") Nurse record, @Param("example") NurseExample example);

    int updateByExample(@Param("record") Nurse record, @Param("example") NurseExample example);

    int updateByPrimaryKeySelective(Nurse record);

    int updateByPrimaryKey(Nurse record);


}