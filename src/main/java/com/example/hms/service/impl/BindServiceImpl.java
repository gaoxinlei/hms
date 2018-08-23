package com.example.hms.service.impl;

import com.example.hms.mapper.CustomerMapper;
import com.example.hms.mapper.RoomBindMapper;
import com.example.hms.mapper.RoomMapper;
import com.example.hms.model.Customer;
import com.example.hms.model.RoomBindData;
import com.example.hms.model.RoomBookParam;
import com.example.hms.service.BindService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service("bindService")
public class BindServiceImpl implements BindService{
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private RoomBindMapper roomBindMapper;
    @Resource
    private RoomMapper roomMapper;
    @Override
    public void bind(RoomBookParam param) {
        RoomBindData data = new RoomBindData();
        BeanUtils.copyProperties(param,data);
        data.setSignTime(LocalDateTime.now());
        Customer customer =customerMapper.selectCustomerByNumber(param.getNumber());
        if(null==customer){
            customer = new Customer();
            BeanUtils.copyProperties(param,customer);
            customerMapper.insert(customer);
        }
        //返回按钮也是提交，防一下。
        roomBindMapper.insert(data);
        roomMapper.changeStatus(param.getRno(),0);
    }

    @Override
    public Customer getLatestCustomer(String rno) {
        RoomBindData data = roomBindMapper.selectLastBindData(rno);
        String number = data.getNumber();
        Customer customer = customerMapper.selectCustomerByNumber(number);
        return customer;
    }

    @Override
    public RoomBindData getLatestBindData(String rno) {
        RoomBindData data = roomBindMapper.selectLastBindData(rno);
        return data;
    }
}
