package com.jetbrain.idea.refactor.extract;

import java.util.ArrayList;
import java.util.List;

public class Generify {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("123");
        String s = (String)list.get(0);

        ArrayList[] listArray = new ArrayList[3];
        listArray[0] = new ArrayList<String>();
        listArray[1] = new ArrayList<String>();
        listArray[2] = new ArrayList<String>();

        ArrayList<String> a = listArray[1];
        ArrayList<Integer> b = listArray[1];


    }
}

class G1<T> {

    public List<T> getList() {
        return new ArrayList<>();
    }
}

class G2<T> {
    public List<T> getList() {
        return new ArrayList<T>();
    }
}

class G3<T> {
    private List<T> dataList = new ArrayList<>();

    void put(T data) {
        dataList.add(data);
    }

    T get(int i) {
        return dataList.get(i);
    }
}

