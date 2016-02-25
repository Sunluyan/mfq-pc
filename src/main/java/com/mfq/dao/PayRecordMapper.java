package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.PayRecord;
import com.mfq.constants.OrderType;
import com.mfq.constants.PayStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface PayRecordMapper {

    public PayRecord findById(@Param("id") long id);

    public PayRecord findByOrderNo(@Param("orderNo") String orderNo);

    public List<PayRecord> findByUId(@Param("orderType") OrderType orderType, @Param("uid") long uid,
                                     @Param("status") PayStatus status);
    
    public long insertOne(PayRecord record);

    public long updateOne(PayRecord record);
    
}