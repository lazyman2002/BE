package org.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Messages {
    private Integer msgID;
    private Integer fromUserID;
    private Integer toGroupID;
    private String messengerData;
    private Timestamp sendTime;

    public Messages() {}

    public Integer getMsgID() {
        return msgID;
    }
    public Integer getFromUserID() {
        return fromUserID;
    }
    public Integer getToGroupID() {
        return toGroupID;
    }
    public String getMessengerData() {
        return messengerData;
    }
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setMsgID(Integer msgID) {
        this.msgID = msgID;
    }
    public void setFromUserID(Integer fromUserID) {
        this.fromUserID = fromUserID;
    }
    public void setToGroupID(Integer toGroupID) {
        this.toGroupID = toGroupID;
    }
    public void setMessengerData(String messengerData) {
        this.messengerData = messengerData;
    }
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Messages messages)) return false;
        return Objects.equals(msgID, messages.msgID) && Objects.equals(fromUserID, messages.fromUserID) && Objects.equals(toGroupID, messages.toGroupID) && Objects.equals(messengerData, messages.messengerData) && Objects.equals(sendTime, messages.sendTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgID, fromUserID, toGroupID, messengerData, sendTime);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Messages{");
        sb.append("msgID=").append(msgID);
        sb.append(", fromUserID=").append(fromUserID);
        sb.append(", toGroupID=").append(toGroupID);
        sb.append(", messengerData='").append(messengerData).append('\'');
        sb.append(", sendTime=").append(sendTime);
        sb.append('}');
        return sb.toString();
    }
}
