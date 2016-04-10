package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.ProductDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@MFQDao
@Component
public interface ProductDetailMapper {

    public ProductDetail findByPid(@Param("pid") long pid);
    
    public long insertDetail(ProductDetail detail);
}
