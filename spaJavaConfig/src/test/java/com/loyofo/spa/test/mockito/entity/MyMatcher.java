package com.loyofo.spa.test.mockito.entity;

import org.mockito.ArgumentMatcher;



public class MyMatcher implements ArgumentMatcher<String> {
    @Override
    public boolean matches(String argument) {
        return argument.startsWith("true");
    }
}