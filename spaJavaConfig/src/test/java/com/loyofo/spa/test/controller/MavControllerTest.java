package com.loyofo.spa.test.controller;

import com.loyofo.spa.java.controller.extra.MavController;
import com.loyofo.spa.java.dao.SpittleRepository;
import com.loyofo.spa.java.entity.Spittle;
import org.hamcrest.Matchers;
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
    public void testModelAndView() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/mav/modelAndView"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedMsg.toArray())));
    }
    @Test
    public void testModelNoView() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/modelNoView.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/mav/modelNoView"))
                .andExpect(MockMvcResultMatchers.view().name("mav/modelNoView"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("modelWithName"))
                .andExpect(MockMvcResultMatchers.model().attribute("modelWithName", Matchers.hasItems(expectedMsg.toArray())));

    }
    @Test
    public void testMapAndView() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/mav/mapAndView"))
                .andExpect(MockMvcResultMatchers.view().name("msg"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("mapAndView"))
                .andExpect(MockMvcResultMatchers.model().attribute("mapAndView", Matchers.hasItems(expectedMsg.toArray())));

    }
    @Test
    public void testMapNoView() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/mav/mapNoView"))
                .andExpect(MockMvcResultMatchers.view().name("mav/mapNoView"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("mapNoView"))
                .andExpect(MockMvcResultMatchers.model().attribute("mapNoView", Matchers.hasItems(expectedMsg.toArray())));
    }
    @Test
    public void testDataNoView() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/mav/dataNoView"))
                .andExpect(MockMvcResultMatchers.view().name("mav/dataNoView"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedMsg.toArray())));
    }
    @Test
    public void testMavObject() throws Exception {
        List<Spittle> expectedMsg = getSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        MavController controller = new MavController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/msg.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/mav/mavObject"))
                .andExpect(MockMvcResultMatchers.view().name("mavView"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("mavData"))
                .andExpect(MockMvcResultMatchers.model().attribute("mavData", Matchers.hasItems(expectedMsg.toArray())));
    }

    private List<Spittle> getSpittleList(int count) {
        List<Spittle> list = new ArrayList<>(20);
        for (int i = 0; i < count; i++) {
            list.add(new Spittle("测试消息 Spittle" + i, new Date()));
        }
        return list;
    }
}
