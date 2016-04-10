package com.mfq.annotation;

import com.mfq.payment.PayAPIType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PayAPIImpl {
    PayAPIType payAPIType();
}