package com.loyofo.spa.webapp.service;

import com.loyofo.spa.webapp.dao.StudentDao;
import com.loyofo.spa.webapp.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
// 如果只在方法上添加事务注解, 则事务只会在该方法被外部调用的时候开启, 而同类中其他方法的调用, 不会开启事务
// @Transactional
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int noTxWithRTexp() {
        logger.warn("在同类里调用事务方法, 抛出运行时异常");
        return saveStudertThrowRTExp();
    }
    public int noTxWithSqlexp() throws SQLException {
        logger.warn("在同类里调用事务方法, 抛出受查异常");
        return saveStudentThrowSQLExp();
    }

    public int saveStudent() {
        Student student = new Student();
        student.setId(100 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("正常插入");
        student.setAddress("正常插入没问题系列");
        student.setAge(12);
        int result = studentDao.saveStudent(student);

        System.out.println(result);
        return result;
    }

    public int saveStudertThrowRTExp() {
        Student student = new Student();
        student.setId(100 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("运行异常");
        student.setAddress("运行时异常, 应该回滚");
        student.setAge(12);
        int result = studentDao.saveStudent(student);
        logger.info("已经存入数据库, 受影响行数:{}", result);
        if (true) {
            logger.warn("抛出运行时异常");
            throw new RuntimeException("运行时异常, 能否回滚");
        }
        return result;
    }

    public int saveStudentThrowSQLExp() throws SQLException {
        Student student = new Student();
        student.setId(100 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("受查异常");
        student.setAddress("受查异常, 不应回滚");
        student.setAge(12);
        int result = studentDao.saveStudent(student);

        logger.info("已经存入数据库, 受影响行数:{}", result);

        if (true) {
            logger.warn("抛出受查异常");
            throw new SQLException("受查异常, 能否回滚");
        }
        return result;
    }


    public int updateStudent() {
        Student student = new Student();
        student.setId(100);
        student.setClassId(10);
        student.setStudentName("正常插入");
        student.setAddress("更新成功");
        student.setAge(10);
        int result = studentDao.update(student);
        System.out.println("更新成功 "+ result);
        return result;

    }
}
