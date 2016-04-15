package com.mfq.dao;

import com.mfq.bean.OpenidUid;
import com.mfq.bean.OpenidUidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenidUidMapper {
    int countByExample(OpenidUidExample example);

    int deleteByExample(OpenidUidExample example);

    int deleteByPrimaryKey(String openid);

    int insert(OpenidUid record);

    int insertSelective(OpenidUid record);

    List<OpenidUid> selectByExample(OpenidUidExample example);

    OpenidUid selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") OpenidUid record, @Param("example") OpenidUidExample example);

    int updateByExample(@Param("record") OpenidUid record, @Param("example") OpenidUidExample example);

    int updateByPrimaryKeySelective(OpenidUid record);

    int updateByPrimaryKey(OpenidUid record);
}