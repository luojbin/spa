package com.loyofo.spa.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AspectService {

    private static Logger logger = LoggerFactory.getLogger(AspectService.class);

    {
        logger.info("AspectService bean 已创建");
    }

    public void oneIntArg(int intArg) {
        System.out.println("oneIntArg 方法, 收到一个参数" + intArg);
    }

    public void aArg(int aArg) {
        System.out.println("aArg 方法, 收到一个参数" + aArg);
    }

    public void twoArg(int aArg, String bArg) {
        System.out.println("twoArg 方法, 收到2个参数" + aArg + ", " + bArg);
    }
}
