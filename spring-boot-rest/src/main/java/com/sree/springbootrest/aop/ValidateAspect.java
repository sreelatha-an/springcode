package com.sree.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspect {

public static final Logger LOGGER = LoggerFactory.getLogger(ValidateAspect.class);
	
	@Around("execution(* com.sree.springbootrest.service.JobService.returnJobPostById(..)) && args(postId)")
	public Object validateAndUpdate(ProceedingJoinPoint pjp,int postId) throws Throwable {
		if (postId<0) {
			 LOGGER.info("PostId is negative, updating it");
			 postId=-postId;
			 LOGGER.info("new Value "+postId);
			}
			Object obj = pjp.proceed(new Object[] {postId}) ;
		 return obj;
	}
	
}
