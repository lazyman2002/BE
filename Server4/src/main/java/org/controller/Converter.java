package org.controller;

import org.model.GroupMembers;
import org.model.Groups;
import org.model.MessagesInfo;
import proto.ServerChat;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
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

    public static ServerChat.GroupInfo groupToProto(Groups groups){
        ServerChat.GroupInfo.Builder builder = ServerChat.GroupInfo.newBuilder();
        if(groups.getGroupID() != null && groups.getGroupID() != 0)
            builder.setGroupID(groups.getGroupID());
        if(groups.getGroupName()!= null && !groups.getGroupName().isEmpty())
            builder.setGroupName(groups.getGroupName());
        return builder.build();
    }

    public static ServerChat.GroupMember groupMemberToProto(GroupMembers groupMembers){
        ServerChat.GroupMember.Builder builder = ServerChat.GroupMember.newBuilder();
        if(groupMembers.getUserID() != null && groupMembers.getUserID() != 0)
            builder.setUserID(groupMembers.getUserID());
        if(groupMembers.getGroupID() != null && groupMembers.getGroupID() != 0)
            builder.setGroupID(groupMembers.getGroupID());
        if(groupMembers.getIsAdmin() != 0 && groupMembers.getGroupID() != null)
            builder.setIsAdmin(true);
        if(groupMembers.getInterview() != null) {
            LocalTime time = groupMembers.getInterview().toLocalTime();
            LocalDate today = LocalDate.now(); // cần ngày bất kỳ để tạo Timestamp
            LocalDateTime interviewDateTime = LocalDateTime.of(today, time);
            Instant instant = interviewDateTime.atZone(ZoneId.systemDefault()).toInstant();

            com.google.protobuf.Timestamp interviewTimestamp = com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(instant.getEpochSecond())
                    .setNanos(instant.getNano())
                    .build();

            builder.setInterview(interviewTimestamp);
        }
        if(groupMembers.getSchedule() != null) {
            LocalDate date = groupMembers.getSchedule().toLocalDate();
            LocalDateTime startOfDay = date.atStartOfDay();
            Instant instant = startOfDay.atZone(ZoneId.systemDefault()).toInstant();

            com.google.protobuf.Timestamp scheduleTimestamp = com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(instant.getEpochSecond())
                    .setNanos(instant.getNano())
                    .build();

            builder.setScheduleDate(scheduleTimestamp);
        }
        return builder.build();
    }

    public static ServerChat.MessageInfo messageToProto(MessagesInfo message){
        ServerChat.MessageInfo.Builder builder = ServerChat.MessageInfo.newBuilder();
        if(message.getMsgID() != null && message.getMsgID() != 0)
            builder.setMsgID(message.getMsgID());
        if(message.getFromUserID() != null && message.getFromUserID() != 0)
            builder.setFromUserID(message.getFromUserID());
        if(message.getToGroupID() != null && message.getToGroupID() != 0)
            builder.setToGroupID(message.getToGroupID());
        if(message.getMessengerData()!= null && !message.getMessengerData().isEmpty())
            builder.setMessengerData(message.getMessengerData());
        if (message.getSendTime() != null) {
            builder.setSendTime(timesToProto(message.getSendTime()));
        }
        return builder.build();
    }

    public static com.google.protobuf.Timestamp timesToProto(Time date) {
        if (date == null) return null;
        long millis = date.getTime();
        long seconds = millis / 1000;
        int nanos = (int) ((millis % 1000) * 1_000_000);
        return com.google.protobuf.Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build();
    }


}
