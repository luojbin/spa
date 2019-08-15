package com.loyofo.spa.webapp.entity;

import com.loyofo.spa.webapp.common.annotation.EntityField;
import com.loyofo.spa.webapp.common.annotation.EntityId;

import java.util.List;
import java.util.Objects;

public class Student {

    @EntityId
    Integer id;

    @EntityField("班级编号")
    Integer classId;
    @EntityField("学生姓名")
    String studentName;
    @EntityField("年龄")
    Integer age;
    @EntityField("地址")
    String address;
    List<Score> scoreList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(classId, student.classId) &&
                Objects.equals(studentName, student.studentName) &&
                Objects.equals(age, student.age) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classId, studentName, age, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", classId=" + classId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
