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
    public void testMockByInterface() {
        // mock() 方法可以通过 interface 构造模拟对象
        MockInterface mockByInterface = mock(MockInterface.class);

        // 行为与普通的 MockInterface 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(mockByInterface);
        mockByInterface.strMethod("mockByInterface 调用 String 方法");
    }

    @Test
    public void testMockByClass() {
        // mock() 方法可以通过普通 class 构造模拟对象
        MockObject mockByClass = mock(MockObject.class);

        // 行为与普通的 MockObject 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(mockByClass);
        mockByClass.strMethod("mockByClass 调用 String 方法");
    }

    @Test
    public void testSpyByInterface() {
        // spy() 方法可以通过 interface 构造模拟对象
        MockInterface spyByInterface = spy(MockInterface.class);

        // 行为与普通的 MockInterface 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(spyByInterface);
        spyByInterface.strMethod("spyByInterface 调用 String 方法");
    }

    @Test
    public void testSpyByClass() {
        // spy() 方法可以通过普通 class 构造模拟对象
        MockObject spyByClass = spy(MockObject.class);

        // 行为与普通的 MockInterface 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(spyByClass);
        spyByClass.strMethod("spyByClass 调用 String 方法");
    }

    @Test
    public void testSpyByRealObj() {
        // spy() 方法可以通过真实对象构造模拟对象, 相当于包装类
        MockObject realObj = new MockObject();
        MockObject spyByRealObj = spy(realObj);

        // 行为与普通的 MockInterface 实例一致, 可作实参, 可调方法
        MockInterface.useInstance(spyByRealObj);
        spyByRealObj.strMethod("spyByRealObj 调用 String 方法");
    }
}
