package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.UserFeedback;
import com.mfq.bean.UserFeedbackExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@MFQDao
public interface UserFeedbackMapper {
    int countByExample(UserFeedbackExample example);

    int deleteByExample(UserFeedbackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFeedback record);

    int insertSelective(UserFeedback record);

    List<UserFeedback> selectByExample(UserFeedbackExample example);

    List<UserFeedback> selectByExampleLimit(@Param("example") UserFeedbackExample example, @Param("start") int start, @Param("size") int size);

    UserFeedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFeedback record, @Param("example") UserFeedbackExample example);

    int updateByExample(@Param("record") UserFeedback record, @Param("example") UserFeedbackExample example);

    int updateByPrimaryKeySelective(UserFeedback record);

    int updateByPrimaryKey(UserFeedback record);
}