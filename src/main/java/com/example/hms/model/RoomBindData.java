package com.example.hms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomBindData {
    private double balance;
    private String rno;
    private String number;
    private LocalDateTime signTime;
}
