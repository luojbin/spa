package com.loyofo.spa.test.controller;

import com.loyofo.spa.java.controller.extra.ParamController;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ParamControllerTest {

    @Test
    public void testQuery() {
        // 构造控制器, 并启动 mvc
        ParamController controller = new ParamController();
        MockMvcBuilders.standaloneSetup(controller).build();

        // 发起mock 请求
        MockMvcRequestBuilders.get("/param/query");
    }
}
