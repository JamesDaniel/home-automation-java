package com.home.automation.homeautomation.rest;

import com.home.automation.homeautomation.models.Heartbeat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

import static com.home.automation.homeautomation.models.Heartbeat.getCurrentTimeHeartbeat;

@RestController
public class HeartbeatRest {

    @RequestMapping(value="/heartbeat")
    public ResponseEntity<Heartbeat> heartbeat() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Heartbeat heartbeat = getCurrentTimeHeartbeat(timestamp);
        heartbeat.setSystemStatus("ok");
        ResponseEntity<Heartbeat> responseEntity = ResponseEntity.ok()
                .body(heartbeat);
        return responseEntity;
    }

}
