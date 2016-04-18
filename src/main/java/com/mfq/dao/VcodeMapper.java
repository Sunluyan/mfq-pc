package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.Vcode;
import com.mfq.bean.VcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@MFQDao
@Component
public interface VcodeMapper {
    int countByExample(VcodeExample example);

    int deleteByExample(VcodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vcode record);

    int insertSelective(Vcode record);

    List<Vcode> selectByExample(VcodeExample example);

    Vcode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vcode record, @Param("example") VcodeExample example);

    int updateByExample(@Param("record") Vcode record, @Param("example") VcodeExample example);

    int updateByPrimaryKeySelective(Vcode record);

    int updateByPrimaryKey(Vcode record);
}