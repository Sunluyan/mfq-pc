package com.mfq.dao;

//import com.mfq.annotation.MFQDao;
import com.mfq.bean.HomeBanner;
import com.mfq.bean.example.HomeBannerExample;
import com.mfq.annotation.MFQDao;;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface HomeBannerMapper {
    int countByExample(HomeBannerExample example);

    int deleteByExample(HomeBannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeBanner record);

    int insertSelective(HomeBanner record);

    List<HomeBanner> selectByExample(HomeBannerExample example);

    HomeBanner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeBanner record, @Param("example") HomeBannerExample example);

    int updateByExample(@Param("record") HomeBanner record, @Param("example") HomeBannerExample example);

    int updateByPrimaryKeySelective(HomeBanner record);

    int updateByPrimaryKey(HomeBanner record);
}