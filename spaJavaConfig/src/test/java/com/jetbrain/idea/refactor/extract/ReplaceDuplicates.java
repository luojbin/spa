package com.jetbrain.idea.refactor.extract;

import com.loyofo.spa.webapp.entity.Spitter;


public class ReplaceDuplicates {
    public static void main(String[] args) {
        CodeA codeA = new CodeA();
        codeA.invoke();
    }
}

class CodeA{
    private Spitter spitter = new Spitter();
    private static final String STATIC_NAME = "我的名字";
    private final String NAME = STATIC_NAME;

    private void method(int i) {
        System.out.println(i);
        System.out.println(i+1);
        System.out.println(i+2);
    }
    private void method2() {
        method(1);
        method(2);
        method(3);
        method(4);
        method(5);
        method(6);
        method(7);
        method(8);
        method(9);
        method(10);
        method(11);
        method(12);
        method(13);
        method(14);
        method(15);

        Spitter spitter = new Spitter();
        spitter.setId(1L);
        spitter.setFirstName(STATIC_NAME);
        spitter.setLastName(STATIC_NAME);
        spitter.setUsername(STATIC_NAME);
        spitter.setPassword(STATIC_NAME);
        Spitter spitter2 = new Spitter();
        spitter2.setId(2L);
        spitter2.setFirstName("");
        spitter2.setLastName("");
        spitter2.setUsername("");
        spitter2.setPassword("");
        Spitter spitter3 = new Spitter();
        spitter3.setId(3L);
        spitter3.setFirstName("");
        spitter3.setLastName("");
        spitter3.setUsername("");
        spitter3.setPassword("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        method(10);
    }
    private void method3() {
        method(1);
        method(1+1);
        method(1+2);
        method(4);
        method(5);
        method(6);
        method(7);
        method(8);
        method(9);
        method(10);
        method(11);
        method(12);
        method(13);
        method(14);
        method(15);


        Spitter spitter = new Spitter();
        spitter.setId(1L);
        spitter.setFirstName("");
        spitter.setLastName("");
        spitter.setUsername("");
        spitter.setPassword("");
        Spitter spitter2 = new Spitter();
        spitter2.setId(2L);
        spitter2.setFirstName("");
        spitter2.setLastName("");
        spitter2.setUsername("");
        spitter2.setPassword("");
        Spitter spitter3 = new Spitter();
        spitter3.setId(3L);
        spitter3.setFirstName("");
        spitter3.setLastName("");
        spitter3.setUsername("");
        spitter3.setPassword("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(spitter);
        System.out.println(spitter2);
        System.out.println(spitter3);
    }

     void invoke() {

         method(1);
         method(2);
         method(3);
         method(4);
         method(5);
         method(6);
         method(7);
         method(8);
         method(9);
         method(10);
         method(11);
         method(12);
         method(13);
         method(14);
         method(15);
         Spitter spitter = new Spitter();
        spitter.setId(1L);
        spitter.setFirstName("");
        spitter.setLastName("");
        spitter.setUsername("");
        spitter.setPassword("");
        Spitter spitter2 = new Spitter();
        spitter2.setId(2L);
        spitter2.setFirstName("");
        spitter2.setLastName("");
        spitter2.setUsername("");
        spitter2.setPassword("");
        Spitter spitter3 = new Spitter();
        spitter3.setId(3L);
        spitter3.setFirstName("");
        spitter3.setLastName("");
        spitter3.setUsername("");
        spitter3.setPassword("");
        method2();
        method3();
    }
}