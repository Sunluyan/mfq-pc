package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.PayRecord;
import com.mfq.bean.PayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@MFQDao
public interface PayRecordMapper {
    int countByExample(PayRecordExample example);

    int deleteByExample(PayRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayRecord record);

    int insertSelective(PayRecord record);

    List<PayRecord> selectByExample(PayRecordExample example);

    PayRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    int updateByPrimaryKeySelective(PayRecord record);

    int updateByPrimaryKey(PayRecord record);
}