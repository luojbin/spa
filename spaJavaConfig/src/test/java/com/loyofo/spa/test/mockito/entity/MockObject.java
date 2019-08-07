package com.loyofo.spa.test.mockito.entity;

public class MockObject implements MockInterface{
    @Override
    public String method(String msg) {
        System.out.println("真实对象收到消息: " + msg);
        return "真实对象收到消息";
    }
}
