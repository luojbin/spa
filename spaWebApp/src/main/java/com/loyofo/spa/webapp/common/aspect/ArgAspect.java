package com.loyofo.spa.webapp.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * service操作日志
 */
@Aspect
@Component
public class ArgAspect {

	private static Logger logger = LoggerFactory.getLogger(ArgAspect.class);

	@Pointcut(value = "execution(* com.loyofo.spa.webapp.service.*.*(..)) && args(a, b)", argNames = "a,b")
	public void oneArg(int a, String b) {
	}

	@Before(value = "oneArg(c, d)", argNames = "c,d")
	public void showLogAround(int c, String d) throws Throwable {
		logger.info("█ █ █ █ █ █ █ 获取到参数, {}, {}" , c, d);
	}

}
