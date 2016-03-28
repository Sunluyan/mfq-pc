package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.UserQuota;
import com.mfq.bean.example.UsersQuotaExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@MFQDao
@Component
public interface UsersQuotaMapper {
    int countByExample(UsersQuotaExample example);

    int deleteByExample(UsersQuotaExample example);

    int insert(UserQuota record);

    int insertSelective(UserQuota record);

    List<UserQuota> selectByExample(UsersQuotaExample example);

    int updateByExampleSelective(@Param("record") UserQuota record, @Param("example") UsersQuotaExample example);

    int updateByExample(@Param("record") UserQuota record, @Param("example") UsersQuotaExample example);

    public Map<String,Object> queryCertifyQuota(@Param("uid") long uid);

    List<UserQuota> certifyDataExample(@Param("example") UsersQuotaExample example, @Param("start") int start, @Param("size") int page);
}