package com.loyofo.spa.test.idea;

import java.util.ArrayList;
import java.util.List;

/**
 * dfdf
 *
 * @author luojbin
 * @version 1.0
 * @date 2019/9/9 16:27
 */
public class Car extends Vehicle {
    public void run() {
        super.run();
    }

    public void invokeMethod() {
        method();
    }

    /** 原方法签名  method() */
    public void method() {
        // 原方法体 输出语句
        System.out.println("原始方法体");
    }

    public void method(List<String> list) {

        List l = new ArrayList();
        System.out.println(l);


        if (list == null) {
            System.out.println(list.getClass());
        } else if (list.size() == 0) {
            System.out.println(list.getClass());
        } else {
            System.out.println(list.getClass());
        }

        String a = "abdcc";
        System.out.println(a);
    }

    public static void main(String[] args) {

    }
}
