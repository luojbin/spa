package com.loyofo.spa.test.mockito;

import com.loyofo.spa.test.mockito.entity.MockInterface;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MockitoTest {

    @Test
    public void testMockObj() {
        MockInterface mock = mock(MockInterface.class);

    }

    @Test
    public void testSpyObject() {

    }
}
