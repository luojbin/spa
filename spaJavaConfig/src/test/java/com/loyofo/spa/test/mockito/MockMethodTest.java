package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockMethodTest {


    @Test
    public void testEmptyReturn() {
        MockInterface mockByInterface = mock(MockInterface.class);
        assertNull(mockByInterface.strMethod("mockByInterface 调用 String 方法"));
        assertEquals(mockByInterface.intMethod(1), 0);
        assertFalse(mockByInterface.booleanMethod(false));
        assertFalse(mockByInterface.booleanMethod(true));
    }
    
    @Test
    public void testStubMethod() {
        MockObject mockObject = mock(MockObject.class);
        String param = "指定入参";
        String return1 = "返回值-1";
        String return2 = "返回值-2";
        String return3 = "返回值-3";
        // 指定要模拟的方法调用
        when(mockObject.strMethod(param))
                // 指定返回值, 重复调用时按给定顺序返回不同的值, 最后一个返回值会重复返回
                .thenReturn(return1)
                .thenReturn(return2)
                .thenReturn(return3);

        // 模拟调用
        assertEquals(mockObject.strMethod(param), return1);
        assertEquals(mockObject.strMethod(param), return2);
        assertEquals(mockObject.strMethod(param), return3);
        assertEquals(mockObject.strMethod(param), return3);
    }

    @Test
    public void testWhen() {
        String param = "指定入参";
        String return1 = "返回值-1";

        // 1.直接先调用一次, 能验证方法被调用过一次
        MockObject mockObject = mock(MockObject.class);
        mockObject.strMethod(param);
        verify(mockObject, times(1)).strMethod(param);

        // 2.模拟对象再次调用方法
        mockObject.strMethod(param);
        // 3.此时方法调用计数是2, 但只能在4以后代码被注释的情况下才能验证, 否则4中的 when(null) 会报错
        // verify(mockObject, times(2)).strMethod(param);

        // 4.紧跟在模拟对象方法调用后, 以 null 或任意 String 调用 when 方法, 都能正常模拟行为
        when("任意参数").thenReturn(return1);
        // 5.when 方法前的方法调用, 该次方法调用被撤销, 调用计数仍然为1
        verify(mockObject, times(1)).strMethod(param);
        // 6.再次调用后能获取指定的返回值, 调用计数+1
        assertEquals(mockObject.strMethod(param), return1);
        verify(mockObject, times(2)).strMethod(param);
    }

    @Test
    public void testThrow() {
        boolean catchedCce = false;
        boolean catchedNpe = false;
        MockObject mockObject = mock(MockObject.class);

        // 可以指定抛出的异常类型, 但无法指定异常信息
        when(mockObject.strMethod("cce")).thenThrow(ClassCastException.class);
        try {
            mockObject.strMethod("cce");
        } catch (Exception e) {
            catchedCce = true;
            assertEquals(e.getClass(), ClassCastException.class);
        }
        assertTrue(catchedCce);

        // 可以指定抛出的异常对象, 可以指定具体异常信息
        NullPointerException npe = new NullPointerException("带信息的自定义异常");
        when(mockObject.strMethod("npe")).thenThrow(npe);
        try {
            mockObject.strMethod("npe");
        } catch (Exception e) {
            catchedNpe = true;
            assertEquals(e.getClass(), npe.getClass());
            assertEquals(e.getMessage(), npe.getMessage());
        }
        assertTrue(catchedNpe);
    }

    @Test
    public void testVoid() {
        MockObject mockObject = mock(MockObject.class);
        List<String> list = new ArrayList<>();
        list.add("列表原有元素");

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                List<String> list = invocation.getArgument(0);
                list.add("模拟对象添加元素");
                return "iii";
            }
        }).when(mockObject).voidMethod(list);
        assertEquals(list.size(), 1);
        mockObject.voidMethod(list);
        assertEquals(list.size(), 2);

        doAnswer(i -> {
            String param = i.getArgument(0);
            return param + " 也是没问题的";
        }).when(mockObject).strMethod("strMethod");
        assertEquals(mockObject.strMethod("strMethod"), "strMethod 也是没问题的");
    }

    @Test
    public void testWhenFail() {
        List<String> list = spy(new ArrayList<>());

        // 真实的list 对象会被调用, 此时会抛出异常, 改用 doReturn 处理
        // when(list.get(0)).thenReturn("空列表");
        doReturn("空列表").when(list).get(0);
        assertEquals(list.get(0), "空列表");

        MockObject mockObject = mock(MockObject.class);
        when(mockObject.intMethod(1)).thenThrow(ClassCastException.class);

        // 此处会抛出 ClassCastException, 改用 doReturn
        // when(mockObject.intMethod(1)).thenReturn(100);
        doReturn(100).when(mockObject).intMethod(1);
        assertEquals(mockObject.intMethod(1), 100);
    }
}
