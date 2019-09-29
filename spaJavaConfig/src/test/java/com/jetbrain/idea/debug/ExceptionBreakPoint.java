package com.jetbrain.idea.debug;

public class ExceptionBreakPoint {
    public static void main(String[] args) {
        try {
            throw new ExBp1();
        } catch (ExBp1 exBp1) {
            System.out.println("exBp1");
        }
        try {
            throw new ExBp2();
        } catch (ExBp1 exBp1) {
            System.out.println("ExBp2");
        }
        try {
            throw new ExBp2();
        } catch (ExBp1 exBp1) {
            System.out.println("ExBp2");
        }

    }
}

class ExBp1 extends RuntimeException{}
class ExBp2 extends ExBp1{}
class ExBp3 extends ExBp1{}