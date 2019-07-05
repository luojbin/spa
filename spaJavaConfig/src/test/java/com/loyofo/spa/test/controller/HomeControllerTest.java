package com.loyofo.spa.test.controller;

import com.loyofo.spa.java.controller.HomeController;
import com.loyofo.spa.java.dao.MsgRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

public class HomeControllerTest {
    @Test
    public void testHomePojo() {
        HomeController controller = new HomeController(null);
        Assert.assertEquals("javahome", controller.home());
    }

    @Test
    public void testHomeMock() throws Exception {
        HomeController controller = new HomeController(null);
        // MockMvcBuilders.standaloneSetup, 独立地启动某个 controller
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        // MockMvcRequestBuilders 模拟发起请求
        mockMvc.perform(MockMvcRequestBuilders.post("/home/viewname"))
                // MockMvcResultMatchers 结果比对
                .andExpect(MockMvcResultMatchers.view().name("javahome"));
    }

    @Test
    public void testGetMsgAndModel() throws Exception {
        List<String> expectedMsg = getMsg(20);
        MsgRepository mockRepository = Mockito.mock(MsgRepository.class);
        Mockito.when(mockRepository.getMessage(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        HomeController controller = new HomeController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/msgAndModel"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("stringList"))
                .andExpect(MockMvcResultMatchers.model().attribute("stringList", Matchers.hasItems(expectedMsg.toArray())));

    }
    @Test
    public void testGetMsgAndModelWithName() throws Exception {
        List<String> expectedMsg = getMsg(20);
        MsgRepository mockRepository = Mockito.mock(MsgRepository.class);
        Mockito.when(mockRepository.getMessage(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        HomeController controller = new HomeController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/msgAndModelWithName"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("modelWithName"))
                .andExpect(MockMvcResultMatchers.model().attribute("modelWithName", Matchers.hasItems(expectedMsg.toArray())));

    }
    @Test
    public void testGetMsgAndMap() throws Exception {
        List<String> expectedMsg = getMsg(20);
        MsgRepository mockRepository = Mockito.mock(MsgRepository.class);
        Mockito.when(mockRepository.getMessage(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        HomeController controller = new HomeController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/msgAndMap"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("msgAndMap"))
                .andExpect(MockMvcResultMatchers.model().attribute("msgAndMap", Matchers.hasItems(expectedMsg.toArray())));

    }
    @Test
    public void testGetMsg() throws Exception {
        List<String> expectedMsg = getMsg(20);
        MsgRepository mockRepository = Mockito.mock(MsgRepository.class);
        Mockito.when(mockRepository.getMessage(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        HomeController controller = new HomeController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/msg"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("stringList"))
                .andExpect(MockMvcResultMatchers.model().attribute("stringList", Matchers.hasItems(expectedMsg.toArray())));

    }

    private List<String> getMsg(int count) {
        List<String> msgs = new ArrayList<>(20);
        for(int i = 0; i< count; i++) {
            msgs.add("测试消息: " + i);
        }
        return msgs;
    }
}
