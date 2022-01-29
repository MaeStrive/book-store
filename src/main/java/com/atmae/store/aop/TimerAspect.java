package com.atmae.store.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Mae
 * 将当前类的对象创建使用维护交由spring容器
 * 将当前类标记为切面类
 */
@Aspect
@Component
@Slf4j
public class TimerAspect {
    /**
     * 映射到那个方法上
     */
    @Around("execution(* com.atmae.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        /** 调用目标发发 login*/
        Object result = pjp.proceed();
        /** 后记录时间*/
        long end = System.currentTimeMillis();
        log.info("耗时" + (end - start) + "ms");
        return result;
    }
}
