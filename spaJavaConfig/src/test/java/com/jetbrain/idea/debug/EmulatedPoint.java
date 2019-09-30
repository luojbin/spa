package com.jetbrain.idea.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void em3(Map o) {
        System.out.println(o);
        Object obj = o.get("e1");
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
        List<Object> l = new ArrayList<>();
        l.add("asa0");
        l.add("asa1");
        l.add("asa2");
        l.add("asa3");
        l.add("asa4");
        l.add("asa5");

        Ep4 e1 = this;
        l.add(e1);

        Map<String, Object> map = new HashMap<>();
        map.put("e1", this);

        System.out.println(l);

        Ep3.em3(map);
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