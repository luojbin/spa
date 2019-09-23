package com.jetbrain.idea.refactor.extract;

public class ExtractMethodObject {
}

class Before {
    public double calVal(int a, String b, double c) {
        double result = new Object() {
            private double cal(int a, String b, double c) {
                a = (int) (a + c);
                b = b + c;
                c = a + b.length();
                double result = a + b.length() + c;


                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                return result;
            }
        }.cal(a, b, c);
        return result;
    }
}

class After {
    public double calVal(int a, String b, double c) {
        return new CalMethod(a,b,c).invoke();
    }
}

class CalMethod {
    private int a;
    private String b;
    private double c;

    public CalMethod(int a, String b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double invoke() {
        a = (int) (a + c);
        b = b + c;
        c = a + b.length();
        return a + b.length() + c;
    }
}