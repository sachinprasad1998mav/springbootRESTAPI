package com.sachin.studentmanagementsystem.services;

import com.sachin.studentmanagementsystem.dtos.CreateStudentDto;
import com.sachin.studentmanagementsystem.dtos.StudentDto;
import com.sachin.studentmanagementsystem.entities.Student;
import com.sachin.studentmanagementsystem.mapper.StudentMapper;
import com.sachin.studentmanagementsystem.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServices {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> studentMapper.toDto(student))
                .collect(Collectors.toList());
    }

    public StudentDto addStudent(CreateStudentDto createStudentDto) {
        Student student = studentMapper.toEntity(createStudentDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        existingStudent.setName(studentDto.getName());
        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toDto(updatedStudent);

    }

    public StudentDto deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
        return studentMapper.toDto(student);
    }
}