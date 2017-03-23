package com.ud.cloudnote.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class loggerBean {
	@Before("within(com.ud.cloudnote.controller..*)")
	public void loggerController(JoinPoint joinPoint){
//		System.out.println("进入Controller组件扫描");
		System.out.println("Get in controller");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
}
