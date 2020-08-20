package com.SpringStarter.example.aop;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.logging.LoggerFactory;


@Aspect
@Component
public class aop {
	private static final Logger logger =(Logger)LoggerFactory.getLogger(aop.class);
	@Around("execution()")
	public Object logprint(ProceedingJoinPoint proceed) throws Throwable {
		Object result = proceed.proceed();
		return result;
	}


}
