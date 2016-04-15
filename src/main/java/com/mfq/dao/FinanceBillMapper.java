package com.mfq.dao;

import com.mfq.bean.FinanceBill;
import com.mfq.bean.FinanceBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinanceBillMapper {
    int countByExample(FinanceBillExample example);

    int deleteByExample(FinanceBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FinanceBill record);

    int insertSelective(FinanceBill record);

    List<FinanceBill> selectByExample(FinanceBillExample example);

    FinanceBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FinanceBill record, @Param("example") FinanceBillExample example);

    int updateByExample(@Param("record") FinanceBill record, @Param("example") FinanceBillExample example);

    int updateByPrimaryKeySelective(FinanceBill record);

    int updateByPrimaryKey(FinanceBill record);
}