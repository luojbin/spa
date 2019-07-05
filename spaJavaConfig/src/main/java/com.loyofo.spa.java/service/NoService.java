package com.loyofo.spa.java.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NoService {
    private static Logger log = LoggerFactory.getLogger(NoService.class);
    {
        log.warn("NoService bean 已创建");
    }
}
