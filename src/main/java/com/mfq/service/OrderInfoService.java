package com.mfq.service;

import com.mfq.bean.FinanceBill;
import com.mfq.bean.FinanceBillExample;
import com.mfq.bean.OrderInfo;
import com.mfq.bean.OrderInfoExample;
import com.mfq.bean.web.Bill2App;
import com.mfq.bean.web.Order2App;
import com.mfq.constants.*;
import com.mfq.dao.FinanceBillMapper;
import com.mfq.dao.OrderInfoMapper;
import com.mfq.utils.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    FinanceBillMapper financeBillMapper;

    @Transactional
    public OrderInfo saveOrderInfo(String proName, BigDecimal price, Integer period, String url, Long uid) throws Exception {

        if (StringUtils.isEmpty(proName)) {
            throw new Exception("产品不能为空");
        }

        if (StringUtils.isEmpty(url)) {
            throw new Exception("请上传手术协议书");
        }
        if (uid == 0) {
            throw new Exception("非法用户");
        }

        if (!isBooking(uid)) {
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
            if (orderInfo.getStatus() == OrderStatus.APPLY.getValue()) {
                return false;
            }
        }
        return true;
    }

    public OrderInfo selectLastByUid(Long uid) {
        OrderInfoExample example = new OrderInfoExample();
        example.or().andUidEqualTo(uid);
        List<OrderInfo> list = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public OrderInfo selectByOrderNo(String orderNo){
        OrderInfoExample example = new OrderInfoExample();
        example.or().andOrderNoEqualTo(orderNo);
        List<OrderInfo> list = mapper.selectByExample(example);
        return list.get(list.size()-1);
    }

    /**
     * 我的订单页需要显示的数据
     * 1.当月待还
     * 2.全部待还
     *
     * @param uid
     * @param model
     */
    public void myPage(Long uid, Model model) {
        FinanceBillExample example = new FinanceBillExample();
        example.or().andUidEqualTo(uid).andStatusNotEqualTo(BillStatus.PAY_OFF.getId());
        List<FinanceBill> list = financeBillMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            model.addAttribute("monthPay", 0);
            model.addAttribute("allPay", 0);
            model.addAttribute("msg","您还没有订单");
            return;
        }
        BigDecimal monthPay = BigDecimal.valueOf(0);
        BigDecimal allPay = BigDecimal.valueOf(0);
        for (FinanceBill financeBill : list) {
            if (financeBill.getDueAt().getTime() <= new Date().getTime() + 1000l * 60 * 60 * 24 * 30) {
                monthPay = monthPay.add(financeBill.getPrice());
            }
            allPay = allPay.add(financeBill.getPrice());
        }

        model.addAttribute("monthPay", monthPay);
        model.addAttribute("allPay", allPay);
    }





    public void myAllPage(Long uid, Model model) {
        OrderInfoExample orderExample = new OrderInfoExample();
        orderExample.or().andUidEqualTo(uid).andStatusBetween(OrderStatus.PASS.getValue(), OrderStatus.ORDER_OK.getValue());
        List<OrderInfo> orders = mapper.selectByExample(orderExample);

        FinanceBillExample billExample = new FinanceBillExample();
        billExample.or().andUidEqualTo(uid);
        billExample.setOrderByClause("id asc");
        List<FinanceBill> bills = financeBillMapper.selectByExample(billExample);

        List<Order2App> list = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            Order2App order2App = new Order2App();
            order2App.setPrice(BigDecimal.valueOf(orders.get(i).getPrice()).setScale(2));
            order2App.setOrderNo(orders.get(i).getOrderNo());
            order2App.setCreatedAt(DateUtil.formatYYYYMMDD(orders.get(i).getCreatedAt()));
            order2App.setName(orders.get(i).getName());
            order2App.setPeriod(orders.get(i).getPeriod());
            order2App.setCurrentPeriod(orders.get(i).getPeriod());

            order2App.setStatus(Order2AppStatus.PAYOFF);
            for (int j = 0; j < bills.size(); j++) {
                if(bills.get(j).getOrderNo().equals(order2App.getOrderNo())){
                    if(bills.get(j).getStatus() == BillStatus.WAIT_PAY.getId()){
                        order2App.setStatus(Order2AppStatus.PAYING);
                        order2App.setCurrentPeriod(bills.get(j).getCurrentPeriod());
                        order2App.setDueAt(DateUtil.formatYYYYMMDD(bills.get(j).getDueAt()));
                        break;
                    }
                    else if(bills.get(j).getStatus() == BillStatus.OVER_TIME.getId()){
                        order2App.setStatus( Order2AppStatus.OVER_TIME);
                        order2App.setCurrentPeriod(bills.get(j).getCurrentPeriod());
                        order2App.setDueAt(DateUtil.formatYYYYMMDD(bills.get(j).getDueAt()));
                        break;
                    }
                }
            }
            list.add(order2App);
        }
        for (Order2App order2App : list) {
            System.out.println(order2App.toString());
        }


        model.addAttribute("list",list);
    }

    public void monthPage(Long uid, Model model) {
        FinanceBillExample billExample = new FinanceBillExample();
        Date dueAt = new Date();
        dueAt.setMonth(dueAt.getMonth()+1);
        billExample.or().andUidEqualTo(uid).andStatusNotEqualTo(BillStatus.PAY_OFF.getId()).andDueAtLessThan(dueAt);
        billExample.setOrderByClause("due_at asc");
        List<FinanceBill> bills = financeBillMapper.selectByExample(billExample);
        List<Bill2App> list = new ArrayList<>();


        OrderInfoExample orderExample = new OrderInfoExample();
        orderExample.or().andUidEqualTo(uid).andStatusBetween(OrderStatus.PASS.getValue(), OrderStatus.ORDER_OK.getValue());
        List<OrderInfo> orders = mapper.selectByExample(orderExample);

        for (FinanceBill bill : bills) {
            Bill2App app = new Bill2App();
            app.setPeriod(bill.getAllPeriod());
            for (OrderInfo order : orders) {
                if(bill.getOrderNo().equals(order.getOrderNo())){
                    app.setName(order.getName());
                    break;
                }
            }
            app.setBillNo(bill.getBillNo());
            app.setCurrent(bill.getCurrentPeriod());
            app.setPrice(bill.getPrice());
            app.setOrderNo(bill.getOrderNo());
            app.setDay(DateUtil.getDayBetweenD(new Date(),bill.getDueAt()));

            list.add(app);
        }
        for (Bill2App bill2App : list) {
            System.out.println(bill2App);
        }

        model.addAttribute("list",list);
    }



    public void allPayPage(Long uid, Model model) {
        FinanceBillExample billExample = new FinanceBillExample();
        Date dueAt = new Date();
        dueAt.setMonth(dueAt.getMonth()+1);
        billExample.or().andUidEqualTo(uid).andStatusNotEqualTo(BillStatus.PAY_OFF.getId());
        billExample.setOrderByClause("due_at asc");
        List<FinanceBill> bills = financeBillMapper.selectByExample(billExample);
        List<Bill2App> list = new ArrayList<>();


        OrderInfoExample orderExample = new OrderInfoExample();
        orderExample.or().andUidEqualTo(uid).andStatusBetween(OrderStatus.PASS.getValue(), OrderStatus.ORDER_OK.getValue());
        List<OrderInfo> orders = mapper.selectByExample(orderExample);

        for (FinanceBill bill : bills) {
            Bill2App app = new Bill2App();
            app.setPeriod(bill.getAllPeriod());
            for (OrderInfo order : orders) {
                if(bill.getOrderNo().equals(order.getOrderNo())){
                    app.setName(order.getName());
                    break;
                }
            }
            app.setBillNo(bill.getBillNo());
            app.setCurrent(bill.getCurrentPeriod());
            app.setPrice(bill.getPrice());
            app.setOrderNo(bill.getOrderNo());
            app.setDay(DateUtil.getDayBetweenD(new Date(),bill.getDueAt()));

            list.add(app);
        }
        for (Bill2App bill2App : list) {
            System.out.println(bill2App);
        }

        model.addAttribute("list",list);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
        OrderInfoService service = ac.getBean(OrderInfoService.class);
        service.allPayPage(9527l, null);
    }

    public void myAllBills(Long uid , String orderNo, Model model) {
        FinanceBillExample billExample = new FinanceBillExample();
        Date dueAt = new Date();
        dueAt.setMonth(dueAt.getMonth()+1);
        billExample.or().andOrderNoEqualTo(orderNo);
        billExample.setOrderByClause("due_at asc");
        List<FinanceBill> bills = financeBillMapper.selectByExample(billExample);
        List<Bill2App> list = new ArrayList<>();


        OrderInfoExample orderExample = new OrderInfoExample();
        orderExample.or().andOrderNoEqualTo(orderNo).andStatusBetween(OrderStatus.PASS.getValue(), OrderStatus.ORDER_OK.getValue());
        List<OrderInfo> orders = mapper.selectByExample(orderExample);

        for (FinanceBill bill : bills) {
            Bill2App app = new Bill2App();
            app.setPeriod(bill.getAllPeriod());
            for (OrderInfo order : orders) {
                if(bill.getOrderNo().equals(order.getOrderNo())){
                    app.setName(order.getName());
                    break;
                }
            }
            app.setBillNo(bill.getBillNo());
            app.setCurrent(bill.getCurrentPeriod());
            app.setPrice(bill.getPrice());
            app.setOrderNo(bill.getOrderNo());
            app.setDay(DateUtil.getDayBetweenD(new Date(),bill.getDueAt()));

            list.add(app);
        }
        for (Bill2App bill2App : list) {
            System.out.println(bill2App);
        }

        model.addAttribute("list",list);

    }
}
