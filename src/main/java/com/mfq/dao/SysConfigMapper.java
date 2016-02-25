package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.SysConfig;
import org.apache.ibatis.annotations.Param;

@MFQDao
public interface SysConfigMapper {

	public Long setConfig(SysConfig config);
	
	public SysConfig getConfig(@Param("key") String key);

	public long updateConfigByKey(SysConfig config);
}
