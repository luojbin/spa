package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.After;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockTest1 {

    @After
    public void afterCheck(){
        validateMockitoUsage();
    }

    @Test
    public void test1() {
        MockObject mockObject = mock(MockObject.class);
        // 错误调用, 没有设置 then
        when(mockObject.booleanMethod(false));
    }

    @Test
    public void test2() {
        MockObject mockObject = mock(MockObject.class);
        mockObject.booleanMethod(false);
        // 错误调用, 没有设置要验证的方法
        verify(mockObject);
    }
}
