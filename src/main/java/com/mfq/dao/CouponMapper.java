package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.coupon.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface CouponMapper {

    public long insertOne(Coupon coupon);

    public Coupon findByCouponNum(@Param("couponNum") String couponNum);

    public List<Coupon> findByUid(@Param("uid") long uid);

    public List<Coupon> findUserValid(@Param("uid") long uid,
                                      @Param("status") int status,
                                      @Param("list") List<Long> list);

    public long updateStatus(@Param("couponNum") String couponNum, @Param("status") int status);

    public Coupon findByUserAndNum(@Param("uid") long uid, @Param("couponNum") String couponNum);

    public long delCoupon(@Param("couponNum") String couponNum);

	public List<Coupon> findCouponsByUidAndStatus(@Param("uid") long uid, @Param("status") int couponStatus);

}