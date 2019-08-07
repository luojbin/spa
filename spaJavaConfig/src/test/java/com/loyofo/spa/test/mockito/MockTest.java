package com.loyofo.spa.test.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    public void testSpy() {
        List<String> strList = spy(new ArrayList<>());
        strList.add("123");
        strList.add("456");
        strList.add("456");
        System.out.println(strList.get(0));
        System.out.println(strList.get(1));
        verify(strList, times(1)).add("123");
        verify(strList, times(2)).add("456");
    }

    @Test
    public void testMockObj() {
        // 构造 mock 对象
        List<Object> list = mock(List.class);
        // 模拟调用
        list.add("String");
        list.add(123);

        // 指定 mock 对象的行为响应
        Mockito.when(list.get(0)).thenReturn("String");
        Mockito.when(list.get(1)).thenReturn(123);

        // 操作 mock 对象, 获取事先设置的响应内容
        Object o1 = list.get(0);
        Object o2 = list.get(1);
        System.out.println(o1);
        System.out.println(o2);

        // 检测调用
        verify(list).add("String2");
        verify(list).add(123);
    }

    @Test
    public void returnsSmartNullsTest() {
        List mocklist = mock(List.class, Mockito.RETURNS_SMART_NULLS);
        System.out.println(mocklist.get(0));
        // 使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mocklist.size());
    }

    @Test
    public void testSmartNull() {
        ListCreator creator = mock(ListCreator.class, Mockito.RETURNS_SMART_NULLS);
        List list = creator.getList("a");
        // 返回的 list 非空, 类型为 LinkedList
        Assert.assertNotNull(list);
        Assert.assertEquals(list.getClass(), LinkedList.class);
    }

    @Test
    public void testDeepStub() {
        MockA a = mock(MockA.class, Mockito.RETURNS_DEEP_STUBS);
        MockB b = a.b;
        MockC c = b.c;

        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(c.getClass());
    }

    @Test
    public void verifying_number_of_invocations() {
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        //验证是否被调用一次，等效于下面的times(1)
        verify(list).add(1);
        verify(list, times(1)).add(1);
        //验证是否被调用2次
        verify(list, times(2)).add(2);
        //验证是否被调用3次
        verify(list, times(3)).add(3);
        //验证是否从未被调用过
        verify(list, never()).add(4);
        //验证至少调用一次
        verify(list, atLeastOnce()).add(1);
        //验证至少调用2次
        verify(list, atLeast(2)).add(2);
        //验证至多调用3次
        verify(list, atMost(3)).add(3);
    }
}

interface ListCreator{
    List getList(String s);
}

class MockA {
    MockB b;
    public MockA(MockB b){
        this.b = b;
        System.out.println(b);
    }
}

class MockB {
    MockC c;
    public MockB(MockC c){
        this.c = c;
        System.out.println(c);
    }
}
class MockC {
}

