package com.jetbrain.idea.debug;

public class EmulatedPoint {
    public static void main(String[] args) {
        new Ep2().em1();
        new Ep3().em1();
        new Ep4().em1();

        new Ep3().em2();
        new Ep4().em2();
    }
}


interface Ep1{
    void em1();
}

class Ep2 implements Ep1{
    @Override
    public void em1() {
        int a = 100;
        for (int i = 0; i < 100; i++) {
            a++;
        }
        System.out.println("方法体执行完了" + a);
    }
}
class Ep3 implements Ep1{
    @Override
    public void em1() {
        int a = 200;
        for (int i = 0; i < 100; i++) {
            a++;
        }
        System.out.println("方法体执行完了" + a);
    }
    public void em2(){
        int b = 200;
        for (int i = 0; i < 100; i++) {
            b++;
        }
        System.out.println("方法体执行完了" + b);
    }
}

class Ep4 extends Ep3 {
    @Override
    public void em1() {
        int a = 300;
        for (int i = 0; i < 100; i++) {
            a++;
        }
        System.out.println("方法体执行完了" + a);
    }

    @Override
    public void em2() {
        int b = 555;
        for (int i = 0; i < 100; i++) {
            b++;
        }
        System.out.println("方法体执行完了" + b);
    }
}