package com.example.hms.mapper;

import com.example.hms.model.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    List<Room> selectAllRooms();

    List<String> selectImageUrls(int roomId);

    int insertRoom(Room room);

    int batchInsertImageUrls(int roomId,@Param("images") List<String> images);
}
