package com.mfq.utils;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;

public class FQUtil {

    private static final Logger logger = LoggerFactory.getLogger(FQUtil.class);

    private final static int [] nums= {3,6,12};
    
    /**
     * 根据金额获取分期
     * @param baseFQMoney
     * @return
     */
    public static Map<String, Object> fenqiMaxCompute(BigDecimal baseFQMoney) {
        Map<String, Object> o = Maps.newTreeMap();
        int max = periodMax(baseFQMoney);
		if (max < 3) {
            o.put("p_num", 0);
            o.put("p_price", 0);
        	return o;
        }
        BigDecimal v = computePeriodPay(max, baseFQMoney);

        o.put("p_num", max);
        o.put("p_price", v);
        return o;
    }
    
    /**
     * 根据金额获取分期
     * @param baseFQMoney
     * @return
     */
    public static Map<Integer, BigDecimal> fenqiCompute(BigDecimal baseFQMoney) {
        Map<Integer, BigDecimal> o = Maps.newTreeMap();
        int min = 3;
        int max = periodMax(baseFQMoney);

        for (int i = min; i <= max; i++) {
            BigDecimal v = computePeriodPay(i, baseFQMoney);
            if(isExistInArray(i, nums))
            	o.put(i, v);
        }
        return o;
    }
    
    private static boolean isExistInArray(int p, int [] ps){
    	for(int i:ps){
    		if(p==i)
    			return true;
    	}
    	return false;
    }

    /**
     * 后台配置录入原始值：团购价、贷款月利率（1.33%） 原始录入价格——团购价 每月应还金额：a*[i*(1+i)^n]/[(1+i)^n-1]
     * （注：a：贷款本金 ，i：贷款月利率， n：贷款月数 ）
     *
     * @param period
     * @param base
     * @return
     */
    public static BigDecimal computePeriodPay(int period, BigDecimal base) {
//        double rate = 0; // 月利率1.25%
//        return base.multiply(new BigDecimal(rate * Math.pow(1 + rate, period)))
//                .divide(new BigDecimal(Math.pow(1 + rate, period) - 1), 2,
//                        BigDecimal.ROUND_HALF_UP);
        return base.divide(new BigDecimal(period), 2, BigDecimal.ROUND_HALF_UP);
    }
    
    public static int periodMax(BigDecimal baseMoney) {


        return 12;
    }


    public static void main(String[] args) {
        int period = 12;
        BigDecimal base = new BigDecimal(10000);
        System.out.println(computePeriodPay(period, base));
        Map<String, Object> yy= fenqiMaxCompute(base);

    }
}