package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.HomeClassify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface HomeClassifyMapper {

    public long insertHomeClassify(HomeClassify classify);
    
    public HomeClassify findById(@Param("id") long id);
    
    public List<HomeClassify> queryAll();
    
    public long updateHomeClassify(HomeClassify model);
    
    public long deleteHomeClassify(@Param("id") long id);
    
}