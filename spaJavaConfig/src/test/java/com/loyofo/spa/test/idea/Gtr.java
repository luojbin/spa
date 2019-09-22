package com.loyofo.spa.test.idea;

public class Gtr extends Vehicle{
    public void run() {
        super.run();
    }


    private String type;
    private int price;
    private int age;


    public String getType() {
        System.out.println("这里进来了");
        System.out.println("这里是断点, 强制返回的地方");
        System.out.println("强制返回, 这里不应该执行");
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
