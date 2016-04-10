package com.mfq.service.user;

import com.mfq.bean.user.UserExtend;
import com.mfq.dao.UserExtendMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserExtendService {

    // private static final Logger logger = LoggerFactory
    // .getLogger(UserExtendService.class);

    @Resource
    UserExtendMapper mapper;

    public int insertUserExtend(UserExtend userExtend) {
        return mapper.insertUserExtend(userExtend);
    }

    public UserExtend getUserExtendByUid(long uid) {

        return mapper.queryUserExtendByUid(uid);

    }

    public int updateUserExtend(UserExtend extend) {
        return mapper.updateUserExtend(extend);

    }
    
    public int updateUserChannelId(String channelId, String mobileType, long uid){
    	return mapper.updateChannelId(channelId, mobileType, uid);
    }

    public int updateUserInviteCode(long uid ,String inviteCode){
        return mapper.updateUserInviteCode(uid,inviteCode);
    }

    public UserExtend getUserExtendByInviteCode(String inviteCode){
        return mapper.queryUserExtendByInviteCode(inviteCode);
    }

}
