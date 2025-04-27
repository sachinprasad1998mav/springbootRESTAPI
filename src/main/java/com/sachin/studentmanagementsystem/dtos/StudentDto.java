package com.sachin.studentmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private List<String> courseNames;
}
