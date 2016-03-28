package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.ProductDetail;
import com.mfq.bean.example.ProductDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface ProductDetailMapper {
    int countByExample(ProductDetailExample example);

    int deleteByExample(ProductDetailExample example);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    List<ProductDetail> selectByExampleWithBLOBs(ProductDetailExample example);

    List<ProductDetail> selectByExample(ProductDetailExample example);

    int updateByExampleSelective(@Param("record") ProductDetail record, @Param("example") ProductDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductDetail record, @Param("example") ProductDetailExample example);

    int updateByExample(@Param("record") ProductDetail record, @Param("example") ProductDetailExample example);
}