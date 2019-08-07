package com.loyofo.spa.test.mockito.entity;

public interface MockInterface {
    String strMethod(String s);
    int intMethod(int n);
    boolean booleanMethod(boolean b);

    static void useInstance(MockInterface instance){
        System.out.println("正常传入 MockInterface 的实例");
    }
}
