package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.user.PresentRecord;
import com.mfq.constants.PresentType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface PresentRecordMapper {

    public List<PresentRecord> queryByUser(@Param("uid") long uid,
                                           @Param("type") PresentType type);

    public long insertOne(PresentRecord presentRecord);
}