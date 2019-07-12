package com.loyofo.spa.webapp.dao.impl;

import com.loyofo.spa.webapp.dao.StudentDao;
import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public Student getStudentById(String id) {
        return null;
    }

    @Override
    public List<Clazz> getAll() {
        return null;
    }
}
