package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.OpLogs;
import com.mfq.bean.example.OpLogsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface OpLogsMapper {
    int countByExample(OpLogsExample example);

    int deleteByExample(OpLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OpLogs record);

    int insertSelective(OpLogs record);

    List<OpLogs> selectByExample(OpLogsExample example);

    OpLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OpLogs record, @Param("example") OpLogsExample example);

    int updateByExample(@Param("record") OpLogs record, @Param("example") OpLogsExample example);

    int updateByPrimaryKeySelective(OpLogs record);

    int updateByPrimaryKey(OpLogs record);

    public boolean addLog(@Param("user") String user,
                          @Param("type") String type, @Param("description") String description,
                          @Param("ip") String ip);
}