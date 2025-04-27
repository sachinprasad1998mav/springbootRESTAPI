package com.sachin.studentmanagementsystem.mapper;

import com.sachin.studentmanagementsystem.dtos.CreateStudentDto;
import com.sachin.studentmanagementsystem.dtos.StudentDto;
import com.sachin.studentmanagementsystem.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    Student toEntity(CreateStudentDto createStudentDto);
}
