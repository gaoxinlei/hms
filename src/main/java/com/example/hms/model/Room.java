package com.example.hms.model;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private int id;
    private String rno;//房间号
    private int floor;//层
    private List<String> images;//图片url
    private double area;//平方米
    private int direct;//朝向，按东西南北1234.
    private String directName;//方向名。
    private int sofa;
    private int condition;
    private int tv;
    private double price;
    private int valid;
}
