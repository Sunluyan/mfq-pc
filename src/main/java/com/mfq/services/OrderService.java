package com.mfq.services;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mfq.bean.*;
import com.mfq.bean.coupon.Coupon;
import com.mfq.constants.*;
import com.mfq.dao.CouponMapper;
import com.mfq.dao.FinanceBillMapper;
import com.mfq.dao.OrderInfoMapper;
import com.mfq.dataservice.context.UserIdHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory
            .getLogger(OrderService.class);

    @Resource
    OrderInfoMapper mapper;
    @Resource
    FinanceBillMapper financeMapper;
    @Resource
    ProductService productService;
    @Resource
    UserService userService;
    @Resource
    UserQuotaService userQuotaService;
    @Resource
    HospitalService hospitalService;
    @Resource
    CouponMapper couponMapper;
    @Resource
    OrderFreedomService freedomService;

    Integer PageSize = 30;



    private Map<Long, Product> getProducts(List<OrderInfo> orders) {
        Map<Long, Product> map = Maps.newHashMap();
        if (CollectionUtils.isEmpty(orders)) {
            return map;
        }
        List<Long> ids = Lists.newArrayList();
        for (OrderInfo order : orders) {
            ids.add(order.getPid());
        }
        List<Product> list = productService.findByIds(ids);
        for (Product p : list) {
            map.put(p.getId(), p);
        }
        return map;
    }

    private Map<Long, String> getUserNames(List<OrderInfo> orders) {
        Map<Long, String> map = Maps.newHashMap();
        if (CollectionUtils.isEmpty(orders)) {
            return map;
        }
        List<Long> ids = Lists.newArrayList();
        for (OrderInfo order : orders) {
            if (!ids.contains(order.getUid())) {
                ids.add(order.getUid());
            }
        }
        List<User> list = userService.queryUsers(ids);
        for (User u : list) {
            map.put(u.getUid(), u.getNick());
        }
        return map;
    }

    public OrderInfo findById(long id) {
        return mapper.findById(id);
    }

    public OrderInfo findByOrderNo(String orderNo) {
        return mapper.findByOrderNo(orderNo);
    }

    public long updateOrder(long id, int oldStatus, int newStatus) {
        return mapper.updateOrderStatusSafe(id, oldStatus, newStatus);
    }

    /**
     * List<Map<String,Object>> selectFinanceByPage(@Param("start")Integer start,
     *
     * @param page
     * @return
     * @Param("size")Integer size,
     * @Param("uid")long uid,
     * @Param("realname")String realname,
     * @Param("phone")String phone,
     * @Param("idcard")String idcard,
     * @Param("endTime")String endTime,
     * @Param("applytimefrom")String applytimefrom,
     * @Param("applytimeto")String applytimeto,
     * @Param("type") String type);
     */
    public List<Map<String, Object>> selectFinanceByPage(Integer page, Integer size, long uid, String realname,
                                                         String phone, String idcard, String applytimefrom, String applytimeto, Integer type, String count) {
        Integer start = (page - 1) * size;
        Date date = new Date();
        date = new Date(date.getTime() - 1000 * 60 * 60 * 24 * 3);
        String endTime = null;
        if (type != null && type == 0) endTime = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

        List<FinanceBill> list = financeMapper.selectFinanceByPage(start, size, uid, realname, phone, idcard,
                endTime, applytimefrom, applytimeto, type, count);
        List<Map<String, Object>> result = new ArrayList<>();
        for (FinanceBill financeBill : list) {
            Map<String, Object> map = new HashMap<>();

            User user = userService.queryUser(financeBill.getUid());
            UserQuota userQuota = userQuotaService.queryUserQuota(financeBill.getUid());
            OrderInfo orderInfo = findByOrderNo(financeBill.getOrderNo());

            map.put("realname", userQuota.getRealname());
            map.put("mobile", user.getMobile());
            map.put("user_type", userQuota.getUserType());
            map.put("due_at", financeBill.getDueAt());
            map.put("price", orderInfo.getPrice());
            map.put("period_pay", orderInfo.getPeriodPay());
            map.put("period", financeBill.getCurPeriod());
            map.put("all_period", financeBill.getAllPeriod());
            map.put("new_balance", financeBill.getNewBalance());
            map.put("bill_at", financeBill.getBillAt());
            map.put("id", financeBill.getId());
            map.put("uid", financeBill.getUid());
            map.put("pay_at", financeBill.getPayAt());
            map.put("orderNo", financeBill.getOrderNo());
            result.add(map);
        }
        return result;
    }



    public OrderType getOrderType(String billNo) throws Exception {
        if (StringUtils.startsWithIgnoreCase(billNo, Constants.RECHARGE_ORDER_PREFIX)) {
            return OrderType.RECHARGE;
        } else if (StringUtils.startsWithIgnoreCase(billNo, Constants.ONLINE_ORDER_PREFIX)) {
            return OrderType.ONLINE;
        } else if (StringUtils.startsWithIgnoreCase(billNo, Constants.REFUND_ORDER_PREFIX)) {
            return OrderType.REFUND;
        } else if (StringUtils.startsWithIgnoreCase(billNo, Constants.FREEDOM_ORDER_PREFIX)) {
            return OrderType.FREEDOM;
        } else {
            throw new Exception("不支持的订单类型！billNo=" + billNo);
        }
    }

    public String getOrderPrefixByOrderType(OrderType type) throws Exception {
        if(type == OrderType.RECHARGE){
            return Constants.RECHARGE_ORDER_PREFIX;
        }else if(type == OrderType.ONLINE){
            return Constants.ONLINE_ORDER_PREFIX;
        }else if(type == OrderType.REFUND){
            return Constants.REFUND_ORDER_PREFIX;
        }else if(type == OrderType.FREEDOM){
            return Constants.FREEDOM_ORDER_PREFIX;
        }else {
            throw new Exception("不支持的订单类型!");
        }
    }

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
        UserQuotaService service = ac.getBean(UserQuotaService.class);
        String fuck = "368,373,392,394,423,425,430,451,452,491,513,522,537,537,544,549,555,577,600,613,617,619,637,682,733,1266,1787,2164,2182,2191,2192,2193,2194,2197,2199,2214,2217,2221,2243,2253,2254,2264,2265,2266,2269,2270,2271,2272,2273,2274,2278,2279,2287,2291,2292,2299,2366,2371,2527,2798,2804,2815,2821,2828,2839,2840,2840,2930,2930,2936,2950,2951,2952,2952,2957,2964,2966,2973,2992,2995,2995,3029,3044,3050,3050,3053,3053,3053,3073,3073,3074,3075,3084,3085,3091,3134,3168,3214,3225,3244,3486,3532,3598,3622,3686";
        for(int i = 0;i<fuck.split(",").length;i++){
            UserQuota userQuota = service.queryUserQuota(Long.parseLong(fuck.split(",")[i]));
            if(userQuota == null)System.out.println(fuck.split(",")[i]);
        }

    }





}






