package com.loyofo.spa.test;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskTest {

    @Test
    public void testTask() {
        System.out.println("test");
    }

    @Test
    public void testTask2() {
        System.out.println("context 上下文");

        Assert.assertTrue(1==1);
    }

    public static void main(String[] args) {
        System.out.println(123);


        int[] array = getArray();
        System.out.println(array.length);

        if (array.length > array[0] && array[1]==array[3]) {
            System.out.println("ok");
        }

        String str = Arrays.toString(array);
        System.out.println(str);

        Arrays.sort(array);

        String str2 = Arrays.toString(array);
        System.out.println(str2);

    }

    public static int[] getArray() {
        return new int[]{1, 6, 3, 1, 5};
    }
}
