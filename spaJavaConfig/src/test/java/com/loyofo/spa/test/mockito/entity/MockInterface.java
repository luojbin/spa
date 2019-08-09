package com.loyofo.spa.test.mockito.entity;

import java.util.List;

public interface MockInterface {
    String strMethod(String s);
    int intMethod(int n);
    boolean booleanMethod(boolean b);
    <T> void voidMethod(List<T> list);

    static void useInstance(MockInterface instance){
        System.out.println("正常传入 MockInterface 的实例");
    }
}
