package com.loyofo.spa.test.junit;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

// 使用 Parameterized 运行类
@RunWith(Parameterized.class)
public class ParameterTest {

    private int expected;
    private int first;
    private int second;

    // 通过构造方法, 用参数对测试用例实例化
    public ParameterTest(int firstNumber, int secondNumber, int expectedResult) {
        this.expected = expectedResult;
        this.first = firstNumber;
        this.second = secondNumber;
    }

    // @Parameters 的静态方法提供测试数据
    @Parameters
    //5
    public static Collection addedNumbers() {
        return Arrays.asList(new Integer[][]{{1, 2, 3}, {2, 3, 5}, {3, 4, 7}, {4, 5, 9}});
    }

    // 测试方法, 用测试类实例的实例域完成测试
    @Test
    public void testSum() {
        //2
        assertEquals("求和方法计算错误", expected, sum(first, second));
    }

    public int sum(int a, int b) {
        // 1
        System.out.println("test");
        double d = Double.parseDouble("1.234");
        boolean c = false;
        for (int i = 0; i < 100; i++) {
            System.out.println(a);
        }

        List<String> list = new ArrayList<>();
        for (String s : list) {

        }

        String s = "";






        return a + b;
    }

    public void voidMethod(){}

    public int intMethod(){return 0;}
}
