package com.sree.springbootrest.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.sree.springbootrest.service.JobService.returnAllJobPosts(..))")
	public void logMethodCall() {
		LOGGER.info("Method called...");
	}
	
	@After("execution(* com.sree.springbootrest.service.JobService.returnAllJobPosts(..))  ||  			execution(* com.sree.springbootrest.service.JobService.updateJobPost(..))")
	public void logMethodExecuted() {
		LOGGER.info("Method executed...");
	}
	
	@AfterThrowing("execution(* com.sree.springbootrest.service.JobService.returnAllJobPosts(..))  ||  			execution(* com.sree.springbootrest.service.JobService.updateJobPost(..))")
	public void logMethodException(JoinPoint jp) {
		LOGGER.info("Method "+jp.getSignature()+" threw an error...");
		LOGGER.info("Method "+jp.getSignature().getName()+" throws an exception...");
	}
	
	@AfterReturning("execution(* com.sree.springbootrest.service.JobService.*(..))  ||  			execution(* com.sree.springbootrest.service.JobService.updateJobPost(..))")
	public void logMethodReturned(JoinPoint jp) {
		LOGGER.info("Method "+jp.getSignature()+" returned...");
		
	}
	
	
	
	
	
}
