package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudentById(Long id);

}
