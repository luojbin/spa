package com.loyofo.spa.webapp.common.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class FirstAspect {
	{
		logger.info("1号切面已创建");
	}
	private static Logger logger = LoggerFactory.getLogger(FirstAspect.class);

	@Pointcut(value = "execution(* com.loyofo.spa.webapp.controller.AspectController.order*(..))")
	public void pointCut() {
	}

	@Before(value = "pointCut()")
	public void before() {
		logger.info("█ 1 号切面 before, 方法前切入");
	}

	@After(value = "pointCut()")
	public void after() {
		logger.info("█ 1 号切面 after, 方法后切入");
	}

	/**
	 * 可以通过 retuning 属性, 绑定返回值到方法参数中
	 */
	@AfterReturning(value = "pointCut()", returning = "result")
	public void AfterReturning(Object result) {
		logger.info("█ 1 号切面 AfterReturning, 返回后切入, 返回值:{}", result);
	}

	/**
	 * 可以通过 throwing 属性, 绑定异常信息到方法参数中
	 * @param exception
	 */
	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void AfterThrowing(Throwable exception) {
		logger.info("█ 1 号切面 AfterThrowing, 异常后切入, {}:{}", exception.getClass(), exception.getMessage());
	}

}
