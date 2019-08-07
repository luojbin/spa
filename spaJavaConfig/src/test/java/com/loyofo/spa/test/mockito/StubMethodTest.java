package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubMethodTest {

    @Test
    public void testMockObj2() {
        String msg = "mock 对象";

        // mock() 方法可以通过普通 class 构造对象
        MockObject mock = mock(MockObject.class);
        // 默认情况下, 构造的 mock 对象中实例方法均没有方法体, 返回 null
        assertNull(mock.strMethod(msg));

        // 可以根据需要为 mock 对象设置指定入参时的返回值
        String returnStr = "stub 方法返回值";
        when(mock.strMethod(msg)).thenReturn(returnStr);

        // 按指定入参调用, 能返回指定返回值, 但非指定入参的调用仍返回 null
        assertEquals(mock.strMethod(msg), returnStr);
        assertNull(mock.strMethod("其他入参"));
    }
}
