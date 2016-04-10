package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.ProductImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface ProductImgMapper {

    public List<ProductImg> findByPid(@Param("pid") long pid);
    
    public long insertImg(ProductImg model);
    
    public void updateOne(ProductImg model);
}