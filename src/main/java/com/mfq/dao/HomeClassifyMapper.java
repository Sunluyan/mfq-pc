package com.mfq.dao;

import com.mfq.bean.HomeClassify;
import com.mfq.bean.example.HomeClassifyExample;
import com.mfq.annotation.MFQDao;;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface HomeClassifyMapper {
    int countByExample(HomeClassifyExample example);

    int deleteByExample(HomeClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HomeClassify record);

    int insertSelective(HomeClassify record);

    List<HomeClassify> selectByExample(HomeClassifyExample example);

    HomeClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HomeClassify record, @Param("example") HomeClassifyExample example);

    int updateByExample(@Param("record") HomeClassify record, @Param("example") HomeClassifyExample example);

    int updateByPrimaryKeySelective(HomeClassify record);

    int updateByPrimaryKey(HomeClassify record);
}