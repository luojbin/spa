package com.loyofo.spa.webapp.dao;

import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.entity.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentById(String id);

    List<Clazz> getAll();

    int saveStudent(Student student);

    int update(Student student);

}
