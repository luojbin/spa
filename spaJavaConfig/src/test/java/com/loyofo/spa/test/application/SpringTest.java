package com.loyofo.spa.test.application;

import com.loyofo.spa.java.config.RootConfig;
import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles("mysql")
public class SpringTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testGetAll() {
        Clazz expected = new Clazz();
        expected.setClassName("终极一班");
        expected.setId(1);
        expected.setStudentAmount(5);

        Clazz actual = helloService.getClazz("1");
        Assert.assertEquals(expected, actual);
    }
}
