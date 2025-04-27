package com.sachin.studentmanagementsystem.repositories;

import com.sachin.studentmanagementsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
