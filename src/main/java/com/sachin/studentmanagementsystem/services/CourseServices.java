package com.sachin.studentmanagementsystem.services;

import com.sachin.studentmanagementsystem.dtos.CourseDto;
import com.sachin.studentmanagementsystem.dtos.CreateCourseDto;
import com.sachin.studentmanagementsystem.entities.Course;
import com.sachin.studentmanagementsystem.mapper.CourseMapper;
import com.sachin.studentmanagementsystem.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServices {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDto)
                .toList();
    }

    public CourseDto addCourse(CourseDto dto) {
        Course course = courseMapper.toEntity(dto);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDto(savedCourse);
    }

    public CourseDto updateCourse(Long id, CourseDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        course.setCourseName(dto.getCourseName());
        course.setCourseDescription(dto.getCourseDescription());
        Course updated = courseRepository.save(course);
        return courseMapper.toDto(updated);
    }

    public CourseDto deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        courseRepository.delete(course);
        return courseMapper.toDto(course);
    }
}