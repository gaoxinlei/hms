package com.example.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StudyController {

    @GetMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>hello</h1>");
        List<String> users = new ArrayList<>();
        users.add("u1");
        users.add("u2");
        map.put("users",users);
        return "success";
    }
}
