package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.SysPassport;
import com.mfq.bean.example.SysPassportExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@MFQDao
@Component
public interface SysPassportMapper {
    int countByExample(SysPassportExample example);

    int deleteByExample(SysPassportExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(SysPassport record);

    int insertSelective(SysPassport record);

    List<SysPassport> selectByExample(SysPassportExample example);

    SysPassport selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") SysPassport record, @Param("example") SysPassportExample example);

    int updateByExample(@Param("record") SysPassport record, @Param("example") SysPassportExample example);

    int updateByPrimaryKeySelective(SysPassport record);

    int updateByPrimaryKey(SysPassport record);


    SysPassport queryValidPassportByTicket(@Param("uid") long uid,
                                           @Param("ticket") String ticket, @Param("status") int status);


    int updateDefaultTicket(@Param("uid") long uid,
                            @Param("ticket") String ticket, @Param("createdAt") Date createdAt,
                            @Param("expiredAt") Date expiredAt);

    int updateByPassport(@Param("uid") long uid, @Param("pass") String plainPassword);
}