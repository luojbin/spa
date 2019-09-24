package com.jetbrain.idea.refactor.extract;

import java.util.ArrayList;
import java.util.List;

public class UseAnyVar {

    public void method(){
        System.out.println("hello");
    }

    public void invokeMethod() {
        int i = 1;
        double d = 1.1;
        List<String> list = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        method();
    }
}