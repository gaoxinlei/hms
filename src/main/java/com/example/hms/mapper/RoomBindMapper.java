package com.example.hms.mapper;

import com.example.hms.model.RoomBindData;

public interface RoomBindMapper {

    int insert(RoomBindData data);
    RoomBindData selectLastSignData(String number);

    RoomBindData selectLastBindData(String rno);
}
