package com.loyofo.spa.webapp.controller;

import com.loyofo.spa.webapp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/tx")
@Controller
public class TxController {

    {
        logger.info("TxController 已创建:{}",  this);
    }

    private static Logger logger = LoggerFactory.getLogger(TxController.class);

    private StudentService service;
    @Autowired
    public TxController(StudentService service){
        this.service = service;
    }

    @RequestMapping("/ok")
    @ResponseBody
    public String saveStudent(){
        int result = service.saveStudent();
        logger.info("事务提交, 顺利保存对象");
        return "commit ok";
    }
    @RequestMapping("/rtExp")
    @ResponseBody
    public String saveStudentWithRtExp(){
        try {
            int result = service.saveStudertThrowRTExp();
        } catch (Exception e) {
            logger.info("运行时异常, 回滚: {}", e.getMessage());
        }
        return "runtimeExp. rollback ok";
    }
    @RequestMapping("/sqlExp")
    @ResponseBody
    public String saveStudentWithSQLExp(){
        try {
            int result = service.saveStudentThrowSQLExp();
        } catch (Exception e) {
            logger.info("受查异常, 不回滚:{}", e.getMessage());
        }
        return "SQLExp. rollback fail";
    }

    @RequestMapping("/noTxrtExp")
    @ResponseBody
    public String noTxSaveStudentWithRtExp(){
        try {
            int result = service.noTxWithRTexp();
        } catch (Exception e) {
            logger.info("运行时异常, 回滚: {}", e.getMessage());
        }
        return "runtimeExp. rollback ok";
    }
    @RequestMapping("/noTxsqlExp")
    @ResponseBody
    public String noTxSaveStudentWithSQLExp(){
        try {
            int result = service.noTxWithSqlexp();
        } catch (Exception e) {
            logger.info("受查异常, 不回滚:{}", e.getMessage());
        }
        return "SQLExp. rollback fail";
    }



}
