package com.jetbrain.idea.refactor.extract;

public class JavaTeacher extends Teacher implements Person {


    @Override
    public void work() {
        String a = "教师在上课";
        System.out.println(a);
    }


    public void earnMoney() {
        double salary = 10000 + 10000 * Math.random();
        System.out.println("教师月入:" + salary);
        System.out.println("教师月入:" + salary);
    }

    public String getName() {
        return "luojbin";
    }

    public void introduce() {
        Object name = getName();
        System.out.println("张三的老师:" + name);
        System.out.println("李四的老师:" + name);
        System.out.println("王五的老师:" + name);
        System.out.println("钱六的老师:" + name);
        System.out.println("田七的老师:" + name);
    }
}
