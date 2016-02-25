package com.mfq.dao;

import com.mfq.annotation.MFQDao;
import com.mfq.bean.Favorites;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@MFQDao
@Component
public interface FavoritesMapper {

	public List<Favorites> findByUid(@Param("uid") long uid);
    
	public long insertFavorite(Favorites favorites);
	
	public long insertFavorites(@Param("list") List<Favorites> favorites);
	
	public long deleteByPids(@Param("uid") long uid, @Param("list") List<Long> list);

	public Favorites findByUidAndPid(@Param("uid") long uid, @Param("pid") long pid);

	public long updateUpdateTime(Favorites favorites);

	
}
