package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.Hospital;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@MFQDao
@Component
public interface HospitalMapper {

    public Hospital findById(@Param("id") long id);
    
    public List<Hospital> findAll();
    
    public long insertHospital(Hospital hospital);  
    
    public List<Map<String,Object>> findProCount(@Param("hosid") List<Long> hosid);

    List<Hospital> selectByKeywords(@Param("keywords") String[] keywords);
}