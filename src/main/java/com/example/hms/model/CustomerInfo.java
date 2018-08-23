package com.example.hms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CustomerInfo {
    private String number;
    private String name;
    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss")
    private LocalDateTime signTime;
}
