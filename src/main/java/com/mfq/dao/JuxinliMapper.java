package com.mfq.dao;

import com.mfq.bean.Juxinli;
import com.mfq.bean.JuxinliExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JuxinliMapper {
    int countByExample(JuxinliExample example);

    int deleteByExample(JuxinliExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Juxinli record);

    int insertSelective(Juxinli record);

    List<Juxinli> selectByExample(JuxinliExample example);

    Juxinli selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Juxinli record, @Param("example") JuxinliExample example);

    int updateByExample(@Param("record") Juxinli record, @Param("example") JuxinliExample example);

    int updateByPrimaryKeySelective(Juxinli record);

    int updateByPrimaryKey(Juxinli record);
}