package com.mfq.service.user;

import com.mfq.bean.user.UsersAuthPic;
import com.mfq.bean.user.UsersAuthPicExample;
import com.mfq.controller.PictureController;
import com.mfq.dao.UsersAuthPicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAuthPicService {

    @Resource
	UsersAuthPicMapper mapper;
    
    final UsersAuthPicExample example = new UsersAuthPicExample();
	private static final Logger logger = LoggerFactory
            .getLogger(UserAuthPicService.class);


    public boolean updatePicByType(Long userId, String key, PictureController.MIAN m) {
    	
    	example.or().andUidEqualTo(userId);
    	List<UsersAuthPic> list =mapper.selectByExample(example);
    	UsersAuthPic pic = null;
    	if(list.size() > 0){
    		pic = list.get(0);
    	}else{
    		pic = defaultUsersAuthPic(userId);
			int i = mapper.insert(pic);
			if (i < 1) {
				logger.warn("user pic is null usersId = {}", userId);
			}
    	}
    	
    	
    	if(m.getId() == PictureController.MIAN.SOCIAL_F.getId()){
    		pic.setSocialF(key);
    	}else if(m.getId() == PictureController.MIAN.SOCIAL_R.getId()){
    		pic.setSocialR(key);
    	}else if(m.getId() == PictureController.MIAN.WORK_PERMIT_F.getId()){
    		pic.setWorkPermitF(key);
    	}else if(m.getId()== PictureController.MIAN.WORK_PERMIT_R.getId()){
    		pic.setWorkPermitR(key);
    	}
        
    	mapper.updateByExampleSelective(pic, example);
        return false;
    }
    
    private UsersAuthPic defaultUsersAuthPic(Long uid){
    	UsersAuthPic pic = new UsersAuthPic();
    	pic.setUid(uid);
    	pic.setIdCard("");
    	pic.setIdCardF("");
    	pic.setIdCardR("");
    	pic.setSocial("");
    	pic.setSocialF("");
    	pic.setSocialF("");
    	pic.setSocialR("");
    	pic.setWorkPermit("");
    	pic.setWorkPermitF("");
    	pic.setWorkPermitR("");
    	return pic;
    	
    }
    
}
