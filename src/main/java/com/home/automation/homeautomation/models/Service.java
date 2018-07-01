package com.home.automation.homeautomation.models;

public class Service {

    private String description;
    private Heartbeat heartbeat;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", heartbeat=" + heartbeat +
                '}';
    }
}
