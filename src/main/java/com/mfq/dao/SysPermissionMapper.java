package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.SysPermission;
import com.mfq.bean.example.SysPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MFQDao
public interface SysPermissionMapper {
    int countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);
}