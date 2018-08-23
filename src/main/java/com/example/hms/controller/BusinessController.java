package com.example.hms.controller;

import com.example.hms.model.Customer;
import com.example.hms.model.CustomerInfo;
import com.example.hms.model.FeedBack;
import com.example.hms.model.Room;
import com.example.hms.model.RoomBindData;
import com.example.hms.model.RoomBookParam;
import com.example.hms.service.BindService;
import com.example.hms.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    //到业务系统的房间首页。
    @GetMapping("/rent/roomList")
    public String businessRoomList(Map<String,Object> map){
        List<Room> allRooms = roomService.getAllRooms();
        map.put("rooms",allRooms);
        return "front/roomList";
    }

    @GetMapping("/rent/bookPage/{roomId}")
    public String toBookPage(@PathVariable("roomId") Integer roomId,Map<String,Object> map){
        Room room = roomService.getRoom(roomId);
        if(null==room){

        }
        map.put("room",room);
        return "front/bookPage";
    }

    @Resource
    private BindService bindService;
    //登记房屋，完成跳转到客房列表。
    @PostMapping("/room/bind")
    public String bindRoom(RoomBookParam param){
        bindService.bind(param);
        return "redirect:/rent/roomList";
    }
    @GetMapping("/rent/customer/{roomId}")
    public String getCustomerInfo(@PathVariable("roomId") Integer roomId,Map<String,Object> map){
        Room room = roomService.getRoom(roomId);
        String rno = room.getRno();
        Customer customer = bindService.getLatestCustomer(rno);
        map.put("room",room);
        map.put("customer",customer);
        RoomBindData data = bindService.getLatestBindData(rno);
        double balance = data.getBalance();
        LocalDateTime signTime = data.getSignTime();
        double price = room.getPrice();
        LocalDateTime now = LocalDateTime.now();
        long day = now.toLocalDate().toEpochDay() - signTime.toLocalDate().toEpochDay();
        balance -=price*day;
        map.put("balance",balance);
        return "front/bookPage";
    }

    @GetMapping("/rent/feedbackRooms")
    public String feedbackRooms(Map<String,Object> map){
        List<Room> allRooms = roomService.getAllRooms();
        map.put("rooms",allRooms);
        Random random = new Random(10);
        List<FeedBack> feedBackList = new ArrayList<>();
        for(int i=0;i<allRooms.size();i++){
            Room room = allRooms.get(i);
            String rno = room.getRno();
            FeedBack feedBack = new FeedBack();
            feedBack.setGrade(1);
            feedBack.setMessage("我住过的最好的宾馆");
            feedBack.setRno(rno);
            feedBackList.add(feedBack);
            room.setFeedbackNumbers(i);
            room.setCustomerNumbers(random.nextInt()%10+10);
        }
        map.put("feedbackList",feedBackList);
        return "front/feedbackRooms";
    }

    @GetMapping("/rent/feedback/{roomId}")
    public String getFeedback(@PathVariable("roomId") String roomId,Map<String,Object> map){
        Room room = roomService.getRoom(1);
        map.put("room",room);
        Random random = new Random(3);
        Map<Integer,String> nameMap = new HashMap<>();
        nameMap.put(1,"明教授");
        nameMap.put(2,"王大刚");
        nameMap.put(3,"陈妍芳");
        nameMap.put(4,"柳黛妍");
        nameMap.put(5,"单洪祯");
        nameMap.put(6,"李廷道");
        nameMap.put(7,"杨一");
        nameMap.put(8,"杨钟键");
        nameMap.put(9,"白付山");
        nameMap.put(10,"钟阿城");
        List<FeedBack> feedBackList = new ArrayList<>();
        for(int i=0;i<10;i++){
            FeedBack feedBack = new FeedBack();
            feedBack.setRno(room.getRno());
            feedBack.setGrade(random.nextInt(3));
            feedBack.setName("");
            feedBack.setMessage("我住过最好的宾馆");
            feedBack.setName(nameMap.get(i+1));
            feedBackList.add(feedBack);
        }
        map.put("feedbackList",feedBackList);
        return "front/feedbackList";
    }

    @GetMapping("/rent/recordList")
    public String recordList(Map<String,Object> map){
        List<Room> allRooms = roomService.getAllRooms();
        map.put("rooms",allRooms);
        Random random = new Random(10);
        List<FeedBack> feedBackList = new ArrayList<>();
        for(int i=0;i<allRooms.size();i++){
            Room room = allRooms.get(i);
            String rno = room.getRno();
            FeedBack feedBack = new FeedBack();
            feedBack.setGrade(1);
            feedBack.setMessage("我住过的最好的宾馆");
            feedBack.setRno(rno);
            feedBackList.add(feedBack);
            room.setFeedbackNumbers(i);
            room.setCustomerNumbers(random.nextInt()%10+10);
        }
        map.put("feedbackList",feedBackList);
        return "front/recordList";
    }
    @GetMapping("/rent/record/{roomId}")
    public String record(@PathVariable("roomId") String roomId,Map<String,Object> map){
        Room room = roomService.getRoom(1);
        map.put("rno",room.getRno());
        //所有住户。
        List<CustomerInfo> customers = new ArrayList<>();
        CustomerInfo c1 = new CustomerInfo();
        c1.setSignTime(LocalDateTime.now().minusDays(7));
        c1.setNumber("110123198701020034");
        c1.setName("舒婷芳");
        CustomerInfo c2 = new CustomerInfo();
        c2.setNumber("230708199708170025");
        c2.setName("王大刚");
        c2.setSignTime(LocalDateTime.now().minusDays(2).minusHours(2));
        CustomerInfo c3 = new CustomerInfo();
        c3.setNumber("130111120020712025x");
        c3.setName("顾德彬");
        c3.setSignTime(LocalDateTime.now().minusDays(1).plusHours(1));
        CustomerInfo c4 = new CustomerInfo();
        c4.setNumber("130111120020712025x");
        c4.setName("顾德彬");
        c4.setSignTime(LocalDateTime.now().minusDays(5).plusHours(3));
        CustomerInfo c5 = new CustomerInfo();
        c5.setNumber("230708199708170025");
        c5.setName("王大刚");
        c5.setSignTime(LocalDateTime.now().minusDays(2).minusHours(6).plusHours(7));
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.sort((a,b)->{return a.getSignTime().compareTo(b.getSignTime());});
        map.put("customers",customers);
        map.put("room",room);
        return "front/record";
    }

}
