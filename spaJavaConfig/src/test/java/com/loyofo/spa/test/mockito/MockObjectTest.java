package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockObjectTest {

    @Test
    public void testObject() {
        MockObject obj = new MockObject();
        assertEquals(obj.strMethod("Object 调用 String 方法"), "真实对象返回内容");
    }

    @Test
    public void testMock() {
        // mock() 方法可以通过 interface/class 构造模拟对象
        MockInterface mockByInterface = mock(MockInterface.class);
        MockObject mockByClass = mock(MockObject.class);

        // 行为与普通的 MockInterface 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(mockByInterface);
        MockInterface.useInstance(mockByClass);
        mockByInterface.strMethod("mockByInterface 调用 String 方法");
        mockByClass.strMethod("mockByClass 调用 String 方法");
    }

    @Test
    public void testSpys() {
        // spy() 方法可以通过 interface/class/已有对象 构造模拟对象
        MockInterface spyByInterface = spy(MockInterface.class);
        MockObject spyByClass = spy(MockObject.class);
        MockObject spyByRealObj = spy(new MockObject());

        // 行为与普通的 MockInterface 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(spyByInterface);
        MockInterface.useInstance(spyByClass);
        MockInterface.useInstance(spyByRealObj);
        spyByInterface.strMethod("spyByInterface 调用 String 方法");
        spyByClass.strMethod("spyByClass 调用 String 方法");
        spyByRealObj.strMethod("spyByRealObj 调用 String 方法");
    }
}
