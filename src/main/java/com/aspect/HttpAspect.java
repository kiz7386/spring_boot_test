package com.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	//方法执行之前就已经先跑了
	@Pointcut("execution(public * com.controller.MemberController.*(..))")
	public void log() {
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//URL
		logger.info("url = [{}]" , request.getRequestURL());
		
		//method
		logger.info("method=[{}]" , request.getMethod());
		
		//ip
		logger.info("ip = [{}]", request.getRemoteAddr());
		
		//類方法
		logger.info("class_method = [{}]" , joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		//參數
		logger.info("args =[{}]" , joinPoint.getArgs());
	}
	
	//再方法執行完之後才跑
	@After("log()")
	public void doAfter() {
		logger.info("22222222222222222");
	}
	
	@AfterReturning(returning = "object" , pointcut ="log()")
	public void doAfterReturning(Object object) {
		logger.info("response = [{}]" , object.toString());
	}
}
