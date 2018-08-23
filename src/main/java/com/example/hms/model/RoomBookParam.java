package com.example.hms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomBookParam {
    private String name;
    private String number;
    private double balance;
    private String rno;
    private LocalDateTime signTime;
}
