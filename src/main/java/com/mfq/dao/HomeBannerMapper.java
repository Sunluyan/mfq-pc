package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.HomeBanner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface HomeBannerMapper {

    public long insertHomeBanner(HomeBanner banner);
    
    public HomeBanner findById(@Param("id") long id);
    
    public List<HomeBanner> queryAll();
    
    public long updateHomeBanner(HomeBanner model);
    
    public long deleteHomeBanner(@Param("id") long id);
    
}