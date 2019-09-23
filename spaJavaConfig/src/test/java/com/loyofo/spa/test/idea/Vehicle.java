package com.loyofo.spa.test.idea;

public abstract class Vehicle {

    protected String name;

    public void run() {
        System.out.println(name + "会跑");
    }
}


class MyClass {
    public void myMethod(int value, double dd) {
    }
}

class MyOtherClass {
    public void myMethodCall(MyClass myClass) {
        double d = 0.5;
        myClass.myMethod(1, d);
    }
}