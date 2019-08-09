package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import com.loyofo.spa.test.mockito.entity.MockObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationTest2 {
    @Mock private MockInterface mock;
    @Spy private MockObject spy;

    @Test
    public void testMockAnnotation() {
        when(mock.strMethod("@Mock")).thenReturn("注入成功, 可以调用");
        assertEquals(mock.strMethod("@Mock"), "注入成功, 可以调用");

        when(spy.strMethod("@Mock")).thenReturn("注入成功, 可以调用");
        assertEquals(spy.strMethod("@Mock"), "注入成功, 可以调用");
    }
}
