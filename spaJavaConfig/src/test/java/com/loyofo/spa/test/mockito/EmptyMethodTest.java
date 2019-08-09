package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class EmptyMethodTest {


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
}
