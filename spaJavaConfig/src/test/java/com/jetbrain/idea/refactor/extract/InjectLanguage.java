package com.jetbrain.idea.refactor.extract;

public class InjectLanguage {

    public void testRegex(){
        String reg = "^[helowrd]+$";
        System.out.println(reg);
    }

    public void testHtml() {
        String html = "<body><div><div id='hello' class='world'>good demo</div>";
        System.out.println(html);
    }

    public void testSQL() {
        // language=MySQL prefix=select  suffix=id
        String sql = " `id`, `student_name`, `age` from `student` group by ";
        System.out.println(sql);
    }

    public void syso(String msg) {
        System.out.println(msg);
    }
}
