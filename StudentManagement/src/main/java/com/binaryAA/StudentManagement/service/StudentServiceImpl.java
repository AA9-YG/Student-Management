package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.Student;
import com.binaryAA.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(id);

        if (student.isPresent())
            return student.get();
        else throw new IllegalArgumentException("Student not found");
    }

}
