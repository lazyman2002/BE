package org.controller;

import org.model.Groups;
import proto.ServerChat;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Converter {
    public static List<Integer> protoMapToList(Map<Integer, Boolean> currentMap) {
        List<Integer> cvidList = new ArrayList<>();
//        Map<Integer, Boolean> currentCVsMap = jobRequest.getCurrentCVsMap();

        for (Map.Entry<Integer, Boolean> entry : currentMap.entrySet()) {
            if (entry.getValue()) {
                cvidList.add(entry.getKey());
            }
        }

        return cvidList;
    }

    public static com.google.protobuf.Timestamp timesToProto(Timestamp sqlTimestamp) {
        Instant instant = sqlTimestamp.toInstant();
        return com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    public static com.google.protobuf.Timestamp timesToProto(java.sql.Date date) {
        if (date == null) {
            return null; // Handle null input
        }

        java.util.Date utilDate = new java.util.Date(date.getTime());
        Instant instant = utilDate.toInstant();

        return com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    public static Timestamp protoToTimeStamp(com.google.protobuf.Timestamp timestamp){
        if(timestamp == null)   return null;
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();

        long millis = seconds * 1000 + nanos / 1_000_000;
        return new Timestamp(millis);
    }

    private static Map<Integer, Boolean> convertHashSetToMap(HashSet<Integer> set) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer value : set) {
            map.put(value, true);
        }
        return map;
    }

    public static ServerChat.GroupMetaInfo groupToProto(Groups groups){
        ServerChat.GroupMetaInfo.Builder builder = ServerChat.GroupMetaInfo.newBuilder();
        if(groups.getGroupID() != null && groups.getGroupID() != 0)
            builder.setGroupID(groups.getGroupID());
        if(groups.getGroupName()!= null && !groups.getGroupName().isEmpty())
            builder.setGroupName(groups.getGroupName());
        return builder.build();
    }
}
