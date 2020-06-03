package com.loyofo.spa.test.app;

import com.loyofo.spa.java.config.RootConfig;
import com.loyofo.spa.java.config.WebConfig;
import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
@ActiveProfiles("mysql")
public class SpringApplicationTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testGetAll() {
        List<Clazz> clazzList = helloService.getAll();
        if (clazzList == null) {
            System.out.println("没查出东西?");
        } else {
            for (Clazz c : clazzList) {
                System.out.println(c);
            }
        }
    }
}
