package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.Student;
import com.binaryAA.StudentManagement.exception.ResourceNotFoundException;
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
    public Student getStudent(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student cannot be found with id: " + id));

        return student;

//        Optional<Student> student = studentRepo.findById(id);
//
//        if (student.isPresent())
//            return student.get();
//        else throw new IllegalArgumentException("Student not found");
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find Student with id: " + id));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAge(student.getAge());
        existingStudent.setGpa(student.getGpa());

        return studentRepo.save(existingStudent);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find Student with id: " + id));
        studentRepo.delete(existingStudent);
        return existingStudent;
    }

}
