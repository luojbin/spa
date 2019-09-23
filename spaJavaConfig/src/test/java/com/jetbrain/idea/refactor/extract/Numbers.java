package com.jetbrain.idea.refactor.extract;

public class Numbers {
    private final int a;
    private final int b;
    private final int c;
    private final double d;
    private final double e;
    private final double f;

    public Numbers(int a, int b, int c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }
}
