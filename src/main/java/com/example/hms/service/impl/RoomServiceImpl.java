package com.example.hms.service.impl;

import com.example.hms.mapper.RoomMapper;
import com.example.hms.model.Room;
import com.example.hms.service.RoomService;
import com.example.hms.util.RoomUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
    @Resource
    private RoomMapper roomMapper;
    @Override
    public List<Room> getAllRooms() {

        List<Room> rooms = roomMapper.selectAllRooms();
        if(!CollectionUtils.isEmpty(rooms)){
            rooms.forEach(room->{
                int roomId = room.getId();
                List<String> images = roomMapper.selectImageUrls(roomId);
                room.setDirectName(RoomUtil.getDirectNameByDirectId(room.getDirect()));
                room.setImages(images);
            });
        }
        return rooms;
    }

    @Override
    public void addRoom(Room room) {
        if(room==null){
            return;
        }
        roomMapper.insertRoom(room);
        List<String> images = room.getImages();
        if(!CollectionUtils.isEmpty(images)){
            roomMapper.batchInsertImageUrls(room.getId(),images);
        }
    }

    @Override
    public Room getRoom(int roomId) {
        return roomMapper.selectRoomById(roomId);
    }
}
