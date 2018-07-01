package com.home.automation.homeautomation.models;


import com.home.automation.homeautomation.enums.ServiceStatus;

import java.sql.Timestamp;

public class Heartbeat {

    private ServiceStatus status;
    private Timestamp timestamp;

    public static Heartbeat getCurrentTimeHeartbeat(Timestamp timestamp) {
        Heartbeat heartbeat = new Heartbeat();
        heartbeat.setTimestamp(timestamp);
        return heartbeat;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
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
                "status='" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
