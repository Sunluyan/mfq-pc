package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.ProductClassify;
import com.mfq.bean.example.ProductClassifyExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface ProductClassifyMapper {
    int countByExample(ProductClassifyExample example);

    int deleteByExample(ProductClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductClassify record);

    int insertSelective(ProductClassify record);

    List<ProductClassify> selectByExample(ProductClassifyExample example);

    ProductClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductClassify record, @Param("example") ProductClassifyExample example);

    int updateByExample(@Param("record") ProductClassify record, @Param("example") ProductClassifyExample example);

    int updateByPrimaryKeySelective(ProductClassify record);

    int updateByPrimaryKey(ProductClassify record);
}