package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        when(mockObject.strMethod(param))
                .thenReturn(return1)
                .thenReturn(return2)
                .thenReturn(return3);

        assertEquals(mockObject.strMethod(param), return1);
        assertEquals(mockObject.strMethod(param), return2);
        assertEquals(mockObject.strMethod(param), return3);
        assertEquals(mockObject.strMethod(param), return3);
        assertEquals(mockObject.strMethod(param), return3);
        assertEquals(mockObject.strMethod(param), return3);
        assertEquals(mockObject.strMethod(param), return3);
    }
}
