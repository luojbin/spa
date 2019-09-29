package com.jetbrain.idea.debug;

public class FieldPoint {
    public static void main(String[] args) {
        Fbp1 fp = new Fbp1();

        for (int i= 0;i<100; i++) {
            System.out.println();
        }

        System.out.println(fp.getAaa());
        System.out.println(fp.getBbb());
        System.out.println(fp.getCcc());

        fp.setAaa(100);
        // fp.setBbb(200);
        // fp.setCcc(300);
        //
        fp.aaa = 111;
        // fp.bbb = 222;
        // fp.ccc = 333;
    }
}

class Fbp1{
    int aaa;
    int bbb;
    int ccc;

    public int getAaa() {
        return aaa;
    }

    public void setAaa(int aaa) {
        this.aaa = aaa;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }

    public int getCcc() {
        return ccc;
    }

    public void setCcc(int ccc) {
        this.ccc = ccc;
    }
}
