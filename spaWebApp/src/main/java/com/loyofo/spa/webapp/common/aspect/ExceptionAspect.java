package com.loyofo.spa.webapp.common.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面抛出异常测试
 * 若 before 抛出异常, 就无法进入业务方法
 * 若其他切面方法抛出异常, 则无法顺利返回结果
 */
@Aspect
@Component
@Order(1)
public class ExceptionAspect {
	{
		logger.info("异常切面已创建");
	}
	private static Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

	@Pointcut(value = "execution(* com.loyofo.spa.webapp.controller.AspectController.exp(..))")
	public void pointCut() {
	}

	@Before(value = "pointCut()")
	public void before() {
		logger.info("█ 异常切面 before, 抛出异常");
		throw new RuntimeException("before 抛出异常");
	}

	@After(value = "pointCut()")
	public void after() {
		logger.info("█ 异常切面 after, 抛出异常");
		throw new RuntimeException("after 抛出异常");
	}

	@AfterReturning(value = "pointCut()")
	public void AfterReturning() {
		logger.info("█ 异常切面 AfterReturning, 抛出异常");
		throw new RuntimeException("AfterReturning 抛出异常");
	}

	@AfterThrowing(value = "pointCut()")
	public void AfterThrowing() {
		logger.info("█ 异常切面 AfterThrowing, 抛出异常");
		throw new RuntimeException("AfterThrowing 抛出异常");
	}

}
