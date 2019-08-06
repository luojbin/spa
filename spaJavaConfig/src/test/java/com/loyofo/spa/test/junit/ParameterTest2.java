package com.loyofo.spa.test.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// 使用 Parameterized 运行类
@RunWith(Parameterized.class)
public class ParameterTest2 {
    // 实例域注入参数
    @Parameter
    public int first;
    @Parameter(1)
    public int second;
    @Parameter(2)
    public int expected;

    // @Parameters 的 name 属性为测试实例命名
    @Parameters(name = "{index}: {0} + {1} = {2}")
    public static Collection addedNumbers() {
        return Arrays.asList(new Integer[][]{{1, 2, 3}, {2, 3, 5}, {3, 4, 7}, {4, 5, 9}});
    }

    @Test
    public void testSum() {
        assertEquals("求和方法计算错误", expected, sum(first, second));
    }

    public int sum(int a, int b){
        return a + b;
    }
}
