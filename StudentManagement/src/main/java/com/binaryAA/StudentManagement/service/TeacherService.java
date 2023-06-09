package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();

    Teacher getTeacher(Long id);

    Teacher saveTeacher(Teacher teacher);

    Teacher updateTeacher(Long id, Teacher teacher);

    Teacher deleteTeacher(Long id);
}
