package com.jetbrain.idea.refactor.extract;

import java.util.function.BiFunction;

public class Teacher {
    public void prepare() {
        System.out.println("教师备课");

        String book = "java 核心技术";

        String note = makeNote(book);

        book += "添加标记";

        System.out.println("备课结束");
        System.out.println("收拾: " + book);
        System.out.println("收拾: " + note);
    }

    private String makeNote(String book) {
        String note = "我的笔记";
        System.out.println("打开" + book);
        System.out.println("打开" + note);
        note += "(已摘抄笔记)";
        return note;
    }

    public void printResult(){
        int a = 133;
        int b = 200;
        int c = 222;
        int d = 421;
        int e = 64;
        int f = 53;

        // 实际上是封装一个函数对象, 后面可以重用
        BiFunction<Integer, Integer, String> addFun = (a1, b1) -> "add: " + add(a1, b1);
        System.out.println(addFun.apply(a, b));
        System.out.println(addFun.apply(c, d));
        System.out.println(addFun.apply(e, f));

        AddClass addClass = new AddClass(a, b);
        System.out.println(addClass.apply());

        System.out.println("add: " + add(a, b));
    }

    public int add(int a, int b){
        return a + b;
    }
}

class AddClass{
    int a;
    int b;

    public AddClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String apply(){
        return "add: " + (a + b);
    }
}