package com.jetbrain.idea.refactor.extract;

public class ReplaceDuplicates {
}

class CodeA{

    public void method() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);

        // System.out.println(9);
    }
    public void method2() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(10);
    }
    public void method3() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
        System.out.println(10);
        System.out.println(10);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(10);
        System.out.println(10);
        System.out.println(10);
    }

    public void invoke() {
        method();
        method2();
        method3();
    }
}