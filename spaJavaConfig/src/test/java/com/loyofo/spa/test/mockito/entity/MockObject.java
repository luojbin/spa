package com.loyofo.spa.test.mockito.entity;

import java.util.List;

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

    @Override
    public <T> void voidMethod(List<T> list) {
        System.out.println("真实对象调用 voidMethod: " + list);
    }

    public final int finalInt(int i){
        System.out.println("final 方法, 无法存根. 传入参数:" + i);
        return 10 * i;
    }

    public int add(int a, int b){
        System.out.println("真实对象调用 add" );
        return a + b;
    }
}
