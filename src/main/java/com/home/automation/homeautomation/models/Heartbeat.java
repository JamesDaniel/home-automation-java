package com.home.automation.homeautomation.models;

public class Heartbeat {

    private long systemTime;

    public static Heartbeat getCurrentTimeHeartbeat(long systemTime) {
        Heartbeat heartbeat = new Heartbeat();
        heartbeat.setSystemTime(systemTime);
        return heartbeat;
    }

    public long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    @Override
    public String toString() {
        return "Heartbeat{" +
                "systemTime=" + systemTime +
                '}';
    }
}
