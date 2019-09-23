package com.jetbrain.idea.refactor.extract;

public class ExtractParamObject {
}

class MutilParam{

    public void method(Numbers numbers, String g){
        System.out.println(numbers.getA());
        System.out.println(numbers.getB());
        System.out.println(numbers.getC());
        System.out.println(numbers.getD());
        System.out.println(numbers.getE());
        System.out.println(numbers.getF());
        System.out.println(g);
    }
}