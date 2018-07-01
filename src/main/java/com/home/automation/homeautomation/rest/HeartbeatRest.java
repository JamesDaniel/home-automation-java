package com.home.automation.homeautomation.rest;

import com.home.automation.homeautomation.enums.ServiceStatus;
import com.home.automation.homeautomation.models.Heartbeat;
import com.home.automation.homeautomation.services.HeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

import static com.home.automation.homeautomation.models.Heartbeat.getCurrentTimeHeartbeat;

@RestController
@Component
public class HeartbeatRest {

    @Autowired
    private HeartbeatService heartbeatService;

    @RequestMapping(value="/heartbeat")
    public ResponseEntity<Heartbeat> heartbeat() {
        heartbeatService.beat();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Heartbeat heartbeat = getCurrentTimeHeartbeat(timestamp);
        heartbeat.setStatus(ServiceStatus.UP);
        ResponseEntity<Heartbeat> responseEntity = ResponseEntity.ok()
                .body(heartbeat);
        return responseEntity;
    }

}
