package com.home.automation.homeautomation.rest;

import com.home.automation.homeautomation.models.Heartbeat;
import com.home.automation.homeautomation.services.HeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.home.automation.homeautomation.models.Heartbeat.getCurrentTimeHeartbeat;

@RestController
@Component
public class HeartbeatRest {

    @Autowired
    private HeartbeatService heartbeatService;

    @RequestMapping(value="/heartbeat")
    public ResponseEntity<Heartbeat> heartbeat() {
        heartbeatService.beat();

        long systemTime = System.currentTimeMillis();
        Heartbeat heartbeat = getCurrentTimeHeartbeat(systemTime);
        ResponseEntity<Heartbeat> responseEntity = ResponseEntity.ok()
                .body(heartbeat);
        return responseEntity;
    }

}
