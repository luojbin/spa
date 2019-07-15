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
@Transactional
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int saveStudent() {
        Student student = new Student();
        student.setId(10 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("正常插入");
        student.setAddress("正常插入没问题系列");
        student.setAge(12);
        return studentDao.saveStudent(student);
    }

    public int saveStudertThrowRTExp() {
        Student student = new Student();
        student.setId(10 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("运行异常");
        student.setAddress("运行时异常, 应该回滚");
        student.setAge(12);
        int result = studentDao.saveStudent(student);

        if (true) {
            throw new RuntimeException("运行时异常, 能否回滚");
        }
        return result;
    }

    public int saveStudentThrowSQLExp() throws SQLException {
        Student student = new Student();
        student.setId(10 + (int) (Math.random() * 99));
        student.setClassId(4);
        student.setStudentName("受查异常");
        student.setAddress("受查异常, 不应回滚");
        student.setAge(12);
        int result = studentDao.saveStudent(student);

        if (true) {
            throw new SQLException("受查异常, 能否回滚");
        }
        return result;
    }
}
