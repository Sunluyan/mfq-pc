package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.Hospital;
import com.mfq.bean.Product;
import com.mfq.constants.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface ProductMapper {

    public Product findById(@Param("id") long id);
    
    public long insertProduct(Product p);
    
    public List<Product> findByClass(@Param("city_id") int city, @Param("list") List<Integer> list, @Param("type") ProductType type);

	public List<Product> findByFlag(@Param("city_id") int city, @Param("flag") int flag, @Param("type") ProductType type);

	public long updateViewNum(@Param("pid") long pidNo);

	public List<Product> queryProductsByType(@Param("type") ProductType type);

	public long updateProductRemain(@Param("pid") long pid, @Param("num") int num, @Param("remain") long remainNum);

	long updateProcuctSaleNum(@Param("pid") long pid);

	List<Product> selectByHospitals(@Param("hospitals") List<Hospital> hospitals);

	List<Product> selectByKeywordsAndHospitalIds(@Param("keywords") String[] keywords, @Param("hospitals") List<Hospital> hospitals,
												 @Param("start") long start, @Param("pagesize") long pagesize);

}
