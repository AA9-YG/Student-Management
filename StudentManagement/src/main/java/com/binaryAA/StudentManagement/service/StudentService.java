package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudent(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student student);

    Student deleteStudent(Long id);

}
