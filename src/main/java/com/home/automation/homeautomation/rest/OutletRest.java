package com.home.automation.homeautomation.rest;

import com.home.automation.homeautomation.enums.OutletStatus;
import com.home.automation.homeautomation.models.Outlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OutletRest {

    @RequestMapping(value="/outlet")
    public ResponseEntity<Outlet> outlet(@RequestParam(value="id", defaultValue="0") long id) {
        Outlet outlet = new Outlet(OutletStatus.ON);
        ResponseEntity<Outlet> responseEntity = ResponseEntity.ok()
                .body(outlet);
        return responseEntity;
    }

}
