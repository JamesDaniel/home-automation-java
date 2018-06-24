package com.home.automation.homeautomation.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class HeartbeatService {

    @Value("${service.account.path}")
    private String pathToServiceAccountJson;

    @Value("${database.url}")
    private String databaseUrl;

    public void setupDatabaseConnection() {
        try {
            FileInputStream serviceAccount = new FileInputStream(pathToServiceAccountJson);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(databaseUrl)
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException ex) {

        }
    }

}
