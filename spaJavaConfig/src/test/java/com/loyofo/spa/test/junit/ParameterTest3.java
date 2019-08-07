package com.loyofo.spa.test.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParameterTest3 {

    @Test
    public void testMutilAssert() {
        String[] params = new String[]{
                "abcd1234",
                "abc",
                "测试失败",
                "12345678901234567890"
        };
        for (String str : params) {
            // testStr() 方法, 参数合法时直接通过, 参数不合法时抛出 RegexException
            try {
                // 正常参数顺利通过
                assertTrue(testStr(str));
            } catch (Exception e) {
                // 异常参数抛出 RegexException, 并返回指定消息
                assertEquals(RegexException.class, e.getClass());
                assertEquals("不符合正则规则: " + str, e.getMessage());
            }
        }
    }

    @Test
    public void testMultiAssert() {
        Object[][] param = new Object[][]{
                {"abcdefgh", true},
                {"abcd", new RegexException("不符合正则规则: abcd")},
                {"1233", new RegexException("不符合正则规则: 1233")},
                {"测试失败", new RegexException("不符合正则规则: 测试失败")},
        };
        for(Object[] p : param){
            String str = p[0].toString();
            try {
                assertTrue(testStr(str));
            } catch (Exception e) {
                Exception expectedException = (Exception) p[1];
                assertEquals(expectedException.getClass(), e.getClass());
                assertEquals(expectedException.getMessage(), e.getMessage());
            }
        }
    }


    @Test
    public void testAdd() {
        int[][] params = new int[][]{
                {1, 2, 3},
                {2, 3, 5},
                {3, 4, 7},
                {4, 5, 9}
        };

        for (int[] p : params) {
            String model = "计算错误: {0} + {1} = {2}";
            String errorMsg = replaceModel(model, p);
            assertEquals(errorMsg, add(p[0], p[1]), p[2]);
        }
    }

    private boolean testStr(String str) {
        String regex = "[0-9a-zA-Z]{8,12}";
        if (str.matches(regex)) {
            return true;
        }
        throw new RegexException("不符合正则规则: " + str);
    }

    private String replaceModel(String model, int... values) {
        String result = model;
        for (int i = 0; i < values.length; i++) {
            result = result.replace("{" + i + "}", values[i] + "");
        }
        return result;
    }

    private int add(int a, int b) {
        return a + b;
    }
}

class RegexException extends RuntimeException {
    RegexException(String message) {
        super(message);
    }
}
