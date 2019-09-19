package com.loyofo.spa.webapp.dao;

public class RearrangeDemo {

    public static final String FINAL_STATIC_FIELD_1 = "1";
    protected static final String FINAL_STATIC_FIELD_2 = "2";
    static final String FINAL_STATIC_FIELD_3 = "3";
    private static final String FINAL_STATIC_FIELD_4 = "4";
    public static String staticField1 = "5";
    protected static String staticField2 = "6";
    static String staticField3 = "7";
    private static String staticField4 = "8";

    static { System.out.println("9");}

    public final String finalField1 = "10";
    protected final String finalField2 = "11";
    final String finalField3 = "12";
    private final String finalField4 = "13";
    public String field1 = "14";
    protected String field2 = "15";
    String field3 = "16";
    private String field4 = "17";

    {System.out.println(18);}

    public RearrangeDemo() { System.out.println("19");}

    public static void staticMethod() { System.out.println("20");}

    public void method() { System.out.println("21");}

}
