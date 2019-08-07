package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmptyMethodTest {


    @Test
    public void testEmptyReturn() {
        MockInterface mockByInterface = mock(MockInterface.class);
        assertNull(mockByInterface.strMethod("mockByInterface 调用 String 方法"));
    }
}
