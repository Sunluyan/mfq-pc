package com.mfq.dao;

import com.mfq.bean.ActivityRecord;
import com.mfq.bean.ActivityRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityRecordMapper {
    int countByExample(ActivityRecordExample example);

    int deleteByExample(ActivityRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityRecord record);

    int insertSelective(ActivityRecord record);

    List<ActivityRecord> selectByExample(ActivityRecordExample example);

    ActivityRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityRecord record, @Param("example") ActivityRecordExample example);

    int updateByExample(@Param("record") ActivityRecord record, @Param("example") ActivityRecordExample example);

    int updateByPrimaryKeySelective(ActivityRecord record);

    int updateByPrimaryKey(ActivityRecord record);
}