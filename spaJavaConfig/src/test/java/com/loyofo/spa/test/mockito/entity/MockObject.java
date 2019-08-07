package com.loyofo.spa.test.mockito.entity;

public class MockObject implements MockInterface{
    @Override
    public String strMethod(String s) {
        System.out.println("真实对象调用 strMethod: " + s);
        return "真实对象返回内容";
    }

    @Override
    public int intMethod(int n) {
        System.out.println("真实对象调用 intMethod: " + n);
        return 2 * n;
    }

    @Override
    public boolean booleanMethod(boolean b) {
        System.out.println("真实对象调用 booleanMethod: " + b);
        return !b;
    }
}
