package com.jetbrain.idea.refactor.extract;

import org.junit.Test;

public class TeacherTest {

    @Test
    public void testWork() {
        JavaTeacher t = new JavaTeacher();
        t.prepare();
        t.work();
        t.earnMoney();
    }

    @Test
    public void testPrepare() {
        Teacher t = new JavaTeacher();
        t.prepare();
    }

    @Test
    public void testPrintResutl() {
        new Teacher().printResult();
    }
}