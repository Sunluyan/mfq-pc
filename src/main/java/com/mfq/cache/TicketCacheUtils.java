package com.mfq.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 为了加速WEB的访问请求，缓存最近3分钟的频繁访问的200个ticket，会有一定风险，后续根据实际线上情况注意！
 * 
 * @author xingyongshan
 *
 */
public class TicketCacheUtils {

    private static final Logger logger = LoggerFactory.getLogger(TicketCacheUtils.class);


}