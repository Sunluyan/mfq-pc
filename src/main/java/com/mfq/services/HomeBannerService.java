package com.mfq.services;


import com.mfq.bean.HomeBanner;
import com.mfq.bean.example.HomeBannerExample;
import com.mfq.constants.BannerType;
import com.mfq.dao.HomeBannerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class HomeBannerService {

    @Resource
	HomeBannerMapper mapper;

    public List<HomeBanner> queryHomeBanners()
	{
		HomeBannerExample example = new HomeBannerExample();
        return mapper.selectByExample(example);
    }
    
    
	public long insertBanner(long id, String img, String name, int type, long pId, String url) {
		BannerType btype = BannerType.fromId(type);
		if(btype == null){
			btype = BannerType.DEFAULT;
		}
		HomeBanner banner = mapper.selectByPrimaryKey(id);
		if(banner != null){
			banner = new HomeBanner(id, name,img, btype, pId,  url);
			return mapper.updateByPrimaryKeySelective(banner);
		}
		banner = new HomeBanner(id, img, name, btype, pId, url);
		return mapper.insert(banner);
	}

	public long deleteBanner(long id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public HomeBanner queryHomeBanner(long id)
	{
		return mapper.selectByPrimaryKey(id);
	}
}


