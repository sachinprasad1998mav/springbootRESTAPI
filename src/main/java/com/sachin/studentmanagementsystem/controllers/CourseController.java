package com.sachin.studentmanagementsystem.controllers;

import com.sachin.studentmanagementsystem.dtos.CourseDto;
import com.sachin.studentmanagementsystem.dtos.CreateCourseDto;
import com.sachin.studentmanagementsystem.entities.Course;
import com.sachin.studentmanagementsystem.services.CourseServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@AllArgsConstructor
@RestController
public class CourseController {
    private final CourseServices courseServices;

    @GetMapping()
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseServices.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping()
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto course) {
        return ResponseEntity.ok(courseServices.addCourse(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody CourseDto course) {
        return ResponseEntity.ok(courseServices.updateCourse(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDto> deleteCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseServices.deleteCourse(id));
    }
}
