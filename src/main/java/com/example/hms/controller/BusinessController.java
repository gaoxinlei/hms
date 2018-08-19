package com.example.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {

    @GetMapping("/main")
    public String toMain(){
        return "dashboard";
    }
}
