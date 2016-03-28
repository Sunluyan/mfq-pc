package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.AreaCity;
import com.mfq.bean.example.AreaCityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@MFQDao
@Component
public interface AreaCityMapper {
    int countByExample(AreaCityExample example);

    int deleteByExample(AreaCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AreaCity record);

    int insertSelective(AreaCity record);

    List<AreaCity> selectByExample(AreaCityExample example);

    AreaCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AreaCity record, @Param("example") AreaCityExample example);

    int updateByExample(@Param("record") AreaCity record, @Param("example") AreaCityExample example);

    int updateByPrimaryKeySelective(AreaCity record);

    int updateByPrimaryKey(AreaCity record);

    List<AreaCity> findAllExistAreaCity();

}