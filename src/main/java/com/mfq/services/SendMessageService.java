package com.mfq.services;

import com.google.common.collect.Maps;
import com.mfq.bean.User;
import com.mfq.bean.example.UsersExample;
import com.mfq.dao.UsersMapper;
import com.mfq.helper.SignHelper;
import com.mfq.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SendMessageService {

    @Resource
	UsersMapper userMapper;

	public int sendMessageToAll(String content) {
		
		int size = 10;
		List<User>  users = null;
		int page = 1;
		UsersExample example = new UsersExample();
		long total = userMapper.countByExample(example);
		long start = 0;
		do{
			start = (page - 1) * size;
			users = userMapper.queryUserByPage(start, size);
			for(int i=0;i<users.size();i++){
				RequestSendMsg(content, users.get(i).getMobile());
				System.out.println(users.get(i).getMobile());
			}
			page=page+1;
		}while(start < total);
		
		return 0;
	}
	
	private String RequestSendMsg(final String content, final String mobiles){
		if(!"15910812061".equals(mobiles)){
			return "";
		}
		final String url = "http://m.5imfq.com/sms/send";
		RunnerUtils.submit(new Thread() {
            @Override
            public void run() {
        		
                Map<String, Object> params = Maps.newHashMap();
                params.put("mobile", mobiles);
                params.put("message", content);
                String sign = SignHelper.makeSign(params);
                String key = MFQAdminUtil.makeKey(params);
                params.put("sign", sign);
                params.put("key", key);
                String body = JsonUtil.writeToJson(params);
                HttpUtil.postJson(url, body, true);
            }
        });

        
        return "";
		
	}

	public static void main(String[] args){

	}

}
