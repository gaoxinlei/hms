package com.example.hms.controller;

import com.example.hms.model.Room;
import com.example.hms.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RoomManageController {
    @Resource
    private RoomService roomService;

    @GetMapping("/manage/allRooms")
    public String getAllRooms(Map<String,Object> map){
        List<Room> allRooms = roomService.getAllRooms();
        map.put("rooms",allRooms);
        return "manage/roomList";
    }

    @GetMapping("/manage/toAddPage")
    public String toAddRoomPage(){
        return "manage/add";
    }
    @PostMapping("/manage/add")
    public String addRoom(Room room){
        roomService.addRoom(room);
        return "redirect:/manage/allRooms";
    }
}
