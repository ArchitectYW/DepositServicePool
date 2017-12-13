package com.yewei.utils;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

public class YeweiReflectionUtils {
	public static Class getOriginalClassWithoutProxy(Object service) {
        if (AopUtils.isAopProxy(service)) {
            if (AopUtils.isJdkDynamicProxy(service)) {
                try {
                    return ((Advised) service).getTargetSource().getTarget().getClass();
                } catch (Exception ex) {
                    return null;
                }
            } else if (AopUtils.isCglibProxy(service)) {
                return service.getClass().getSuperclass();
            } else {
                return null;
            }
        } else {
            return service.getClass();
        }
    }
}
