package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.OrderFreedom;
import com.mfq.bean.OrderFreedomExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface OrderFreedomMapper {
    int countByExample(OrderFreedomExample example);

    int deleteByExample(OrderFreedomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderFreedom record);

    int insertSelective(OrderFreedom record);

    List<OrderFreedom> selectByExample(OrderFreedomExample example);

    OrderFreedom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderFreedom record, @Param("example") OrderFreedomExample example);

    int updateByExample(@Param("record") OrderFreedom record, @Param("example") OrderFreedomExample example);

    int updateByPrimaryKeySelective(OrderFreedom record);

    int updateByPrimaryKey(OrderFreedom record);
}