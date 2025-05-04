package com.sree.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	
	@Around("execution(* com.sree.springbootrest.service.JobService.returnAllJobPosts(..))")
	public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis();
		LOGGER.info("Time taken="+(end-start)+" ms for "+pjp.getSignature().getName());
		 return obj;
	}

}
