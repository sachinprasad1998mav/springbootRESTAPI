package com.sachin.studentmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseDto {
    private Long id;
    private String courseName;
    private String courseDescription;
}
