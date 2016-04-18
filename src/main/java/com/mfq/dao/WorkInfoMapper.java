package com.mfq.dao;

import com.mfq.bean.WorkInfo;
import com.mfq.bean.WorkInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkInfoMapper {
    int countByExample(WorkInfoExample example);

    int deleteByExample(WorkInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkInfo record);

    int insertSelective(WorkInfo record);

    List<WorkInfo> selectByExample(WorkInfoExample example);

    WorkInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByExample(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    int updateByPrimaryKeySelective(WorkInfo record);

    int updateByPrimaryKey(WorkInfo record);
}