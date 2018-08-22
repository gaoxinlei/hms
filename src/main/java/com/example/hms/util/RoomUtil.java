package com.example.hms.util;

import java.util.HashMap;
import java.util.Map;

public class RoomUtil {
    private static final Map<Integer,String> DIRECT_MAP = new HashMap<>();
    static {
        DIRECT_MAP.put(1,"东");
        DIRECT_MAP.put(2,"南");
        DIRECT_MAP.put(3,"西");
        DIRECT_MAP.put(4,"北");
    }
    public static String getDirectNameByDirectId(int directId){
        return DIRECT_MAP.get(directId);
    }
}
