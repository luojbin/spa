package com.loyofo.spa.test.controller;

import com.loyofo.spa.java.controller.HomeController;
import com.loyofo.spa.java.controller.SpittleController;
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

/**
 * 通过 junit + mock 测试 mvc 组件功能, 使用 mock 测试的大致流程如下
 * <p>
 * 1. 制造测试数据
 * 2. Mockito mock依赖组件, 指定待测方法及返回值
 * 3. 构造待测控制器
 * 4. MockMvcBuilders 单独启动待测 controller, 构造 mockmvc 应用
 * 5. MockMvcRequestBuilders 构造 mock 请求
 * 6. mockmvc 应用发起 mock 请求, 返回 resultAction
 * 7. resultAction 通过 andExpect 方法校验结果
 */
public class SpittrControllerTest {
    // 当成普通方法来测试获取首页
    @Test
    public void testHomePojo() {
        HomeController controller = new HomeController();
        Assert.assertEquals("home", controller.home());
    }

    // 通过 mock, 模拟 mvc 访问测试访问首页, homepage
    @Test
    public void testHomeMock() throws Exception {
        // 1. 制造测试数据, 无数据
        // 2. Mockito mock 依赖组件, 没有依赖
        // 3. 构造待测控制器
        HomeController controller = new HomeController();
        // 4. MockMvcBuilders 单独启动待测 controller, 构造 mockmvc 应用
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        // 5. MockMvcRequestBuilders 构造 mock 请求
        // 6. mockmvc 应用发起 mock 请求, 返回 resultAction
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                // 7. resultAction 通过 andExpect 方法校验结果
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    // mock 模拟获取最前面的20条 spittle
    @Test
    public void testGetRecentSpittle() throws Exception {
        // 1. 制造测试数据: 制造20条模拟数据
        List<Spittle> expectedMsg = getSpittleList(20);
        // 2. Mockito mock依赖组件, 指定待测方法及返回值
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);
        // 3. 构造待测控制器
        SpittleController controller = new SpittleController(mockRepository);
        // 4. MockMvcBuilders 单独启动待测 controller, 构造 mockmvc 应用
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        // 5. MockMvcRequestBuilders 构造 mock 请求
        // 6. mockmvc 应用发起 mock 请求, 返回 resultAction
        mockMvc.perform(MockMvcRequestBuilders.get("/recentSpittles"))
                // 7. resultAction 通过 andExpect 方法校验结果
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedMsg.toArray())));
    }

    // 测试提供参数, 根据参数查询需要的 spittle 列表
    @Test
    public void testGetSomeSpittle() throws Exception {
        // 制造20条模拟数据
        List<Spittle> expectedMsg = getSpittleList(50);
        // mock spittle 数据库
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        // 拦截方法, 返回指定的模拟数据
        Mockito.when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedMsg);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=238900&count=50"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedMsg.toArray())));
    }

    // 测试不提供参数时, 能否正常查询
    @Test
    public void testGetSpittleWithNoArg() throws Exception {
        // 制造20条模拟数据
        List<Spittle> expectedMsg = getSpittleList(20);
        // mock spittle 数据库
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        // 拦截方法, 返回指定的模拟数据
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedMsg);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", Matchers.hasItems(expectedMsg.toArray())));
    }

    private List<Spittle> getSpittleList(int count) {
        List<Spittle> list = new ArrayList<>(20);
        for (int i = 0; i < count; i++) {
            list.add(new Spittle("测试消息 Spittle" + i, new Date()));
        }
        return list;
    }
}
