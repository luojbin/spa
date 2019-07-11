package com.loyofo.spa.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NoService {
    private static Logger log = LoggerFactory.getLogger(NoService.class);
    {
        log.info("NoService bean 已创建");
    }
}
