package com.loyofo.spa.webapp.dao.impl;

import com.loyofo.spa.webapp.dao.StudentDao;
import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student getStudentById(String id) {
        return null;
    }

    @Override
    public List<Clazz> getAll() {
        return null;
    }

    @Override
    public int saveStudent(Student s) {
        String sql = "insert into student (id, clazz_id, student_name, age, address) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, s.getId(), s.getClassId(), s.getStudentName(), s.getAge(), s.getAddress());
    }

}
