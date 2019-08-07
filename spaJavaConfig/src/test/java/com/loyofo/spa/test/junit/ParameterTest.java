package com.loyofo.spa.test.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

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
    public static Collection addedNumbers() {
        return Arrays.asList(new Integer[][]{{1, 2, 3}, {2, 3, 5}, {3, 4, 7}, {4, 5, 9}});
    }

    // 测试方法, 用测试类实例的实例域完成测试
    @Test
    public void testSum() {
        assertEquals("求和方法计算错误", expected, sum(first, second));
    }

    public int sum(int a, int b){
        return a + b;
    }
}
