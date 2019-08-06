package com.loyofo.spa.test.junit;


import org.junit.*;

public class DemoTest {

    @BeforeClass
    public static void initMethod() {
        System.out.println("@BeforeClass 方法, 在该类所有测试方法开始前运行, 只运行一次");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass 方法, 在该类所有测试方法结束后运行, 只运行一次");
        Assert.assertTrue(true);
    }

    @Before
    public void beforeMethod() {
        System.out.println("@Before 方法, 在该类每个测试方法前运行, 有几个测试方法就会运行几次");
    }

    @After
    public void afterMethod() {
        System.out.println("@After 方法, 在该类每个测试方法前运行, 有几个测试方法就会运行几次");
    }

    @Test
    @Ignore
    public void test1() {
        System.out.println("@Test 测试方法 1, 批量测试时被忽略, 只能单独运行");
    }

    @Test
    public void test2() {
        System.out.println("@Test 测试方法 2");
    }

    @Test
    public void test3() {
        System.out.println("@Test 测试方法 3");
    }
}
