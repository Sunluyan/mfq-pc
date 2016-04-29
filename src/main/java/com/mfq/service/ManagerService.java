package com.mfq.service;

import com.mfq.bean.FinanceBill;
import com.mfq.bean.OrderInfo;
import com.mfq.bean.OrderInfoExample;
import com.mfq.constants.BillStatus;
import com.mfq.constants.OrderStatus;
import com.mfq.dao.FinanceBillMapper;
import com.mfq.dao.OrderInfoMapper;
import com.mfq.dao.UsersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liuzhiguo1 on 16/4/19.
 */
@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory
            .getLogger(ManagerService.class);

    @Resource
    UserService userService;
    @Resource
    FinanceBillMapper financeBillMapper;
    @Resource
    OrderInfoMapper orderInfoMapper;

    /**
     * 批准用户订单
     * 1.更改订单状态
     * 2.生成账单
     */
    @Transactional
    public void ratify(Long uid, String orderNo) throws Exception {

        OrderInfoExample example = new OrderInfoExample();
        example.or().andOrderNoEqualTo(orderNo);
        List<OrderInfo> list = orderInfoMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            throw new RuntimeException("订单不存在");
        }
        OrderInfo order = list.get(0);
        if (order.getStatus() == OrderStatus.PASS.getValue() || order.getStatus() == OrderStatus.ORDER_OK.getValue()) {
            throw new RuntimeException("订单状态为:" + OrderStatus.fromValue(order.getStatus()).getName() + ",无法进行操作");
        }
        order.setStatus(OrderStatus.PASS.getValue());
        orderInfoMapper.updateByPrimaryKeySelective(order);

        BigDecimal allPrice = BigDecimal.valueOf(order.getPrice());
        BigDecimal countPrice = BigDecimal.ZERO;
        for (int i = 0; i < order.getPeriod(); i++) {
            FinanceBill financeBill = new FinanceBill();
            financeBill.setOrderNo(orderNo);
            financeBill.setUid(uid);
            financeBill.setBillNo(OrderInfoService.makeOrderNo(uid).replace("wmn", "wbl"));
            financeBill.setStatus(BillStatus.WAIT_PAY.getId());
            financeBill.setAllPeriod(order.getPeriod());
            financeBill.setCurrentPeriod(i + 1);
            financeBill.setUpdatedAt(new Date());
            Date dueAt = new Date();
            dueAt.setMonth(dueAt.getMonth() + i + 1);
            dueAt.setHours(0);
            dueAt.setMinutes(0);
            dueAt.setSeconds(0);
            financeBill.setDueAt(dueAt);
            BigDecimal currentPrice = allPrice.divide(BigDecimal.valueOf(order.getPeriod()), 2, BigDecimal.ROUND_HALF_DOWN);
            financeBill.setPrice(currentPrice);
            if (i == order.getPeriod() - 1) {
                financeBill.setPrice(allPrice.subtract(countPrice));
            }
            countPrice = countPrice.add(currentPrice);

            long count = financeBillMapper.insertSelective(financeBill);
            if (count != 1) {
                throw new RuntimeException("插入出错,回退");
            }
        }

    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring.xml");
        ManagerService service = ac.getBean(ManagerService.class);
        service.ratify(9529l, "wmn2016042615190326312539");
    }


}
