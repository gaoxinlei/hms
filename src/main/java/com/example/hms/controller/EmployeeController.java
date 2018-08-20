package com.example.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 环境测试代码。
 */
@Controller
public class EmployeeController {

    @GetMapping("/emps")
    public String emps(){
        return "emp/list";
    }
}
