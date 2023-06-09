package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.Teacher;
import com.binaryAA.StudentManagement.exception.ResourceNotFoundException;
import com.binaryAA.StudentManagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepo;

    @Override
    public List<Teacher> getTeachers() {
        return (List<Teacher>) teacherRepo.findAll();
    }

    @Override
    public Teacher getTeacher(Long id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher cannot be found with id: " + id));
        return teacher;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher cannot be found with id: " + id));

        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setCourse(teacher.getCourse());
        existingTeacher.setSalary(teacher.getSalary());

        return teacherRepo.save(existingTeacher);
    }

    @Override
    public Teacher deleteTeacher(Long id) {
        Teacher existingTeacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher cannot be found with id: " + id));

        teacherRepo.delete(existingTeacher);
        return existingTeacher;
    }
}
