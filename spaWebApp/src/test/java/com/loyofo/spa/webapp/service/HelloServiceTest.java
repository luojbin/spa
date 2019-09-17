package com.loyofo.spa.webapp.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HelloServiceTest {


    @Test
    public void getClazz() {
    }


    @Test
    public void logIt() {
    }

    @Test
    public void getAllStackTrace() {
    }

    @Test
    public void getStudentById() {
    }

    @Test
    public void getAllClazz() {
    }

    /** 自动带上注释跑了 */
    @Test
    public void getAll() {
        List<String> stringList = new ArrayList<>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");

        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals("4")){
                System.out.println("找到了");
            } else {
                System.out.println("不是这个");
            }
        }
    }

}