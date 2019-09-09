package com.loyofo.spa.test.mockito;

import org.junit.Test;

public class StringTest {
    @Test
    public void testAdd() {
        String a = "a";
        String b = "b";
        String ab = a + b;
    }

    @Test
    public void testBuilder() {
        String a = "a";
        String b = "b";
        String ab = new StringBuilder().append(a).append(b).toString();
    }

    @Test
    public void testSpa() {
        System.out.println("zzghe");
        System.out.println("这个到底要怎么玩, 为什么提交失败");
    }
}
