package com.loyofo.spa.test.controller;

import com.loyofo.spa.java.controller.HomeController;
import com.loyofo.spa.java.controller.extra.MavController;
import com.loyofo.spa.java.dao.SpittleRepository;
import com.loyofo.spa.java.entity.Spittle;
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
import java.util.Date;
import java.util.List;

public class MavControllerTest {

    @Test
    public void testGetMsgAndModel() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
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
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
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
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
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
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/msg"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("stringList"))
                .andExpect(MockMvcResultMatchers.model().attribute("stringList", Matchers.hasItems(expectedMsg.toArray())));

    }

    private List<Spittle> getSpittleList(int count) {
        List<Spittle> list = new ArrayList<>(20);
        for (int i = 0; i < count; i++) {
            list.add(new Spittle("测试消息 Spittle" + i, new Date()));
        }
        return list;
    }
}
