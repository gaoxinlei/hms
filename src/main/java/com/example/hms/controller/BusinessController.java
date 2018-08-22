package com.example.hms.controller;

import com.example.hms.model.Room;
import com.example.hms.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class BusinessController {

    @Resource
    private RoomService roomService;
    @GetMapping("/main")
    public String toMain(){
        return "dashboard";
    }

    //客房管理列表页。
    @GetMapping("/roomList")
    public String listPage(Map<String,Object> map){
        List<Room> roomList = roomService.getAllRooms();
        map.put("rooms",roomList);
        return "homeList";
    }
}
