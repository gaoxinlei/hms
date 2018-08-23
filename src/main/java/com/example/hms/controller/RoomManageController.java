package com.example.hms.controller;

import com.example.hms.model.Room;
import com.example.hms.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    @GetMapping("/manage/view/{id}")
    public String preview(@PathVariable("id") Integer id){
        return "manage/preview";
    }

    @GetMapping("/manage/excel")
    public String excel(Map<String,Object> map){
        List<Room> allRooms = roomService.getAllRooms();
        Random random = new Random();
        allRooms.forEach(room->{
            int customerNumbers = random.nextInt(50);
            room.setCustomerNumbers(customerNumbers);
            int feedbackNumbers = random.nextInt(customerNumbers);
            room.setFeedbackNumbers(feedbackNumbers);
            room.setGrade(random.nextInt(3)+1);
        });
        map.put("rooms",allRooms);
        return "front/excel";
    }
}
