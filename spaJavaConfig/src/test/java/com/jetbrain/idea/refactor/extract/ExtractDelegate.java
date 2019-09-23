package com.jetbrain.idea.refactor.extract;

public class ExtractDelegate {
    public void testGetInfo() {
        String msg = new A().getInfo();
    }
}


class A {
    private final B info = new B();

    // 在类 A 中完成 getInfo 的具体工作
    public String getInfo() {
        return info.getInfo();
    }
}

class B {
    String info;

    public B() {
    }

    // 在新建的 Info 类中完成 getInfo 的具体工作
    public String getInfo() {
        return ("my info detail: " + info);
    }
}

