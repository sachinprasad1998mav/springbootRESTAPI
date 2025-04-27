package com.sachin.studentmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateStudentDto {
    private String name;
    private List<Long> courseIds;
}
