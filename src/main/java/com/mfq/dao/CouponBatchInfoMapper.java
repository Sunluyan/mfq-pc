package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.coupon.CouponBatchInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface CouponBatchInfoMapper {
	
    public long insertOne(CouponBatchInfo couponBatchInfo);
    
    public CouponBatchInfo findById(@Param("id") long id);

    public CouponBatchInfo findByBatch(@Param("batch") String batch);

    public List<CouponBatchInfo> findByBatchs(@Param("batchs") String batchs);

}