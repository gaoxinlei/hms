package com.example.hms.service;

import com.example.hms.model.Customer;
import com.example.hms.model.RoomBindData;
import com.example.hms.model.RoomBookParam;

public interface BindService {
    void bind(RoomBookParam param);

    Customer getLatestCustomer(String rno);

    RoomBindData getLatestBindData(String rno);
}
