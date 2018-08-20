package com.example.hms.model;

import lombok.Data;

@Data
public class Room {
    private int id;
    private int number;//房间号
    private int floor;//层
    private String image;//图片url
    private double area;//平方米
    private int direct;//朝向，按东西南北1234.
}
