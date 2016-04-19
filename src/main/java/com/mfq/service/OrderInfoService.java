package com.mfq.service;

import com.mfq.bean.OrderInfo;
import com.mfq.bean.OrderInfoExample;
import com.mfq.constants.Constants;
import com.mfq.constants.OrderStatus;
import com.mfq.constants.OrderType;
import com.mfq.dao.OrderInfoMapper;
import com.mfq.utils.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

/**
 * Created by liuzhiguo1 on 16/4/18.
 */
@Service
public class OrderInfoService {

    private static final Logger logger = LoggerFactory
            .getLogger(OrderInfoService.class);

    @Resource
    OrderInfoMapper mapper;

    @Transactional
    public OrderInfo saveOrderInfo(String proName, BigDecimal price,Integer period,String url,Long uid) throws Exception{

        if(StringUtils.isEmpty(proName)){
            throw new Exception("产品不能为空");
        }
        if(StringUtils.isEmpty(url)){
            throw new Exception("请上传手术协议书");
        }
        if(uid == 0){
            throw new Exception("非法用户");
        }

        if(!isBooking(uid)){
            throw new Exception("已有在申请订单");
        }


        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setName(proName);
        orderInfo.setPrice(price.longValue());
        orderInfo.setPeriod(period);
        orderInfo.setUid(uid);
        orderInfo.setImg(url);
        orderInfo.setOrderNo(makeOrderNo(uid));
        orderInfo.setOrderType(OrderType.ONLINE.getId());
        orderInfo.setStatus(OrderStatus.APPLY.getValue());
        mapper.insertSelective(orderInfo);
        return orderInfo;
    }

    public static String makeOrderNo(long pId) {
        String pHex = Long.toHexString(pId);
        Integer randomInt = new Random().nextInt(9999);
        String randomStr = new DecimalFormat("0000").format(randomInt);
        StringBuilder sb = new StringBuilder(Constants.ONLINE_ORDER_PREFIX);
        sb.append(DateUtil.formatCurTimeLong());
        sb.append(randomStr);
        sb.append(StringUtils.leftPad(pHex, 4, "0"));
        logger.info("After Make Order No is : {}", sb.toString());
        return sb.toString();
    }

    public boolean isBooking(Long uid) {
        OrderInfoExample example = new OrderInfoExample();
        example.or().andUidEqualTo(uid);
        List<OrderInfo> list = mapper.selectByExample(example);
        for (OrderInfo orderInfo : list) {
            if(orderInfo.getStatus() == OrderStatus.APPLY.getValue()){
                return false;
            }
        }
        return true;
    }

    public OrderInfo selectLastByUid(Long uid) {
        OrderInfoExample example = new OrderInfoExample();
        example.or().andUidEqualTo(uid);
        List<OrderInfo> list = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(list.size()-1);
    }
}
