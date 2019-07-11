package com.loyofo.spa.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private static Logger log = LoggerFactory.getLogger(HelloService.class);
    {
        log.info("HelloService bean 已创建");
    }

    public void logIt(String msg) {
        log.info("controller 让我记录: {}", msg);
    }
}
