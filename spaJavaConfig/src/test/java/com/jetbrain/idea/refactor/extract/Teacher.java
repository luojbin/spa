package com.jetbrain.idea.refactor.extract;

public class Teacher {
    public void prepare() {
        System.out.println("教师备课");

        String book = "java 核心技术";

        String note = makeNote(book);

        book += "添加标记";

        System.out.println("备课结束");
        System.out.println("收拾: " + book);
        System.out.println("收拾: " + note);
    }

    private String makeNote(String book) {
        String note = "我的笔记";
        System.out.println("打开" + book);
        System.out.println("打开" + note);
        note += "(已摘抄笔记)";
        return note;
    }
}
