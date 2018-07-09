package com.home.automation.homeautomation.services;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.home.automation.homeautomation.config.FirebaseInit;
import com.home.automation.homeautomation.enums.ServiceStatus;
import com.home.automation.homeautomation.models.Heartbeat;
import com.home.automation.homeautomation.models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class HeartbeatService {

    @Value("${service.description}")
    private String serviceDescription;

    @Autowired
    private FirebaseInit firebaseInit;

    private Service service;

    public void beat() {
        updateDatabaseValue();
    }

    @Scheduled(fixedRate = 10000)
    private void updateDatabaseValue() {
        Service service = new Service();
        service.setDescription(serviceDescription);
        service.setStatus(ServiceStatus.UP);
        Heartbeat heartbeat = new Heartbeat();
        heartbeat.setSystemTime(System.currentTimeMillis());
        service.setHeartbeat(heartbeat);
        firebaseInit.getRef().setValueAsync(service);
    }

    private void getDatabaseValue() {
        DatabaseReference ref = firebaseInit.getRef();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                service = dataSnapshot.getValue(Service.class);
                System.out.println(service);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

}
