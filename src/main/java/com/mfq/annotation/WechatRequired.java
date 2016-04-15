package com.mfq.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * Created by liuzhiguo1 on 16/4/11.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface WechatRequired {
    /**
     * 是否需要微信环境
     * @return
     */
    boolean value() default true;
}
