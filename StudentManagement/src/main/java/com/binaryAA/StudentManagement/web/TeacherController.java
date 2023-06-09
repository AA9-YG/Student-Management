package com.binaryAA.StudentManagement.web;

import com.binaryAA.StudentManagement.entity.Teacher;
import com.binaryAA.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getTeachers() {
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.getTeacher(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Teacher> getTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.updateTeacher(id, teacher), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.deleteTeacher(id), HttpStatus.NO_CONTENT);
    }

}
