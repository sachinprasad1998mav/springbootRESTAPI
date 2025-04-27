package com.sachin.studentmanagementsystem.controllers;

import com.sachin.studentmanagementsystem.dtos.CreateStudentDto;
import com.sachin.studentmanagementsystem.dtos.StudentDto;
import com.sachin.studentmanagementsystem.services.StudentServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
@AllArgsConstructor
@RestController
public class StudentController {
    private final StudentServices studentServices;

    @GetMapping()
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> allStudents = studentServices.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @PostMapping()
    public ResponseEntity<StudentDto> addStudent(@RequestBody CreateStudentDto createStudentDto) {
        return ResponseEntity.ok(studentServices.addStudent(createStudentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentServices.updateStudent(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentServices.deleteStudent(id));
    }
}