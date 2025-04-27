package com.sachin.studentmanagementsystem.mapper;

import com.sachin.studentmanagementsystem.dtos.CourseDto;
import com.sachin.studentmanagementsystem.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto courseDto);
}
