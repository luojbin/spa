package com.loyofo.spa.webapp.common.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ThirdAspect {

	{
		logger.info("3号切面已创建");
	}
	private static Logger logger = LoggerFactory.getLogger(ThirdAspect.class);

	@Pointcut(value = "execution(* com.loyofo.spa.webapp.controller.AspectController.order*(..))")
	public void pointCut() {
	}

	@Before(value = "pointCut()")
	public void before() {
		logger.info("█ 3 号切面 before, 方法前切入");
	}

	@After(value = "pointCut()")
	public void after() {
		logger.info("█ 3 号切面 after, 方法后切入");
	}

	@AfterReturning(value = "pointCut()")
	public void AfterReturning() {
		logger.info("█ 3 号切面 AfterReturning, 返回后切入");
	}

	@AfterThrowing(value = "pointCut()")
	public void AfterThrowing() {
		logger.info("█ 3 号切面 AfterThrowing, 异常后切入");
	}

}
