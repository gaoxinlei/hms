package com.example.hms.service;

import com.example.hms.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();

    void addRoom(Room room);

    Room getRoom(int roomId);
}
