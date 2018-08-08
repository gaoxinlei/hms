package com.example.hms.controller;

import com.example.hms.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;
    @GetMapping("/student/add")
    public String addStudent(){
        studentService.batchInsert(null);
        return "success";
    }
}
