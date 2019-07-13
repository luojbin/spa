package com.loyofo.spa.webapp.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	{
		logger.info("环绕切面已创建");
	}
	private static Logger logger = LoggerFactory.getLogger(AroundAspect.class);

	@Pointcut(value = "execution(* com.loyofo.spa.webapp.controller.AspectController.around*(..))")
	public void pointCut() {
	}

	@Around(value = "pointCut()")
	public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		try {
			try {
				logger.info("环绕通知, 等价于 Before 通知");
				result = joinPoint.proceed();
			} finally {
				logger.info("环绕通知, 等价于 After 通知");
			}
			logger.info("环绕通知, 等价于 AfterReturning 通知");
			return result;
		} catch (Throwable e) {
			logger.info("环绕通知, 等价于 AfterThrowing 通知");
			throw e;
		}
	}

}
