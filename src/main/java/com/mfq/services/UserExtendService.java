package com.mfq.services;

import com.mfq.bean.UserExtend;
import com.mfq.bean.example.UsersExtendExample;
import com.mfq.dao.UsersExtendMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserExtendService {

    //private static final Logger logger = LoggerFactory
    //        .getLogger(UserExtendService.class);

    @Resource
	UsersExtendMapper mapper;

    public int insertUserExtend(UserExtend userExtend){
    	return mapper.insert(userExtend);
    }

	public UserExtend getUserExtendByUid(long uid) {
		UsersExtendExample example = new UsersExtendExample();
		example.or().andUidEqualTo(uid);
		return mapper.selectByExample(example).get(0);
		
	}

	public int updateUserExtend(UserExtend extend) {
		UsersExtendExample example = new UsersExtendExample();
		example.or().andUidEqualTo(extend.getUid());
		return mapper.updateByExampleSelective(extend,example);
		
	}

}
