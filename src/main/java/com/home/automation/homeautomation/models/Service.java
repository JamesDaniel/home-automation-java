package com.home.automation.homeautomation.models;

import com.home.automation.homeautomation.enums.ServiceStatus;

public class Service {

    private String description;
    private ServiceStatus status;
    private Heartbeat heartbeat;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public Heartbeat getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Heartbeat heartbeat) {
        this.heartbeat = heartbeat;
    }

    @Override
    public String toString() {
        return "Service{" +
                "description='" + description + '\'' +
                ", status=" + status +
                ", heartbeat=" + heartbeat +
                '}';
    }
}
