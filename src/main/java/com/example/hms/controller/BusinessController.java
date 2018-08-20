package com.example.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class BusinessController {

    @GetMapping("/main")
    public String toMain(){
        return "dashboard";
    }

    //客房管理列表页。
    @GetMapping("/homeList")
    public String listPage(Map<String,Object> map){

        return "homeList";
    }
}
