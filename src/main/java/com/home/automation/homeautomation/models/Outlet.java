package com.home.automation.homeautomation.models;

import com.home.automation.homeautomation.enums.OutletStatus;

public class Outlet {

    private OutletStatus outletStatus;

    public Outlet(OutletStatus outletStatus) {
        this.outletStatus = outletStatus;
    }

    public OutletStatus getOutletStatus() {
        return outletStatus;
    }

    public void setOutletStatus(OutletStatus outletStatus) {
        this.outletStatus = outletStatus;
    }

    @Override
    public String toString() {
        return "Outlet{" +
                "outletStatus=" + outletStatus +
                '}';
    }
}
