package com.home.automation.homeautomation.models;


import java.sql.Timestamp;

public class Heartbeat {

    private String systemStatus;
    private Timestamp timestamp;

    public static Heartbeat getCurrentTimeHeartbeat(Timestamp timestamp) {
        Heartbeat heartbeat = new Heartbeat();
        heartbeat.setTimestamp(timestamp);
        return heartbeat;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Heartbeat{" +
                "systemStatus='" + systemStatus + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
