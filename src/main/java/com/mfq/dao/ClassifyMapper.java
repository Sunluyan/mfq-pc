package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.ProductClassify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface ClassifyMapper {

    public long insertOne(ProductClassify productClassify);

    public ProductClassify findById(@Param("id") int id);

    public List<ProductClassify> findByRootId(@Param("rootId") int rootId);

	public List<Integer> findClassIdsByRootId(@Param("rootId") int rootId);

    List<ProductClassify> findAll();

}