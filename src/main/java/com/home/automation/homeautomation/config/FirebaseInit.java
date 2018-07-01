package com.home.automation.homeautomation.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInit {

    @Value("${service.account.path}")
    private String pathToServiceAccountJson;

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${database.reference}")
    private String databaseReference;

    private FirebaseAuth defaultAuth;
    private FirebaseDatabase defaultDatabase;
    private DatabaseReference ref;

    @PostConstruct
    private void init() {
        setupDatabase();
        connectToDatabase();
    }

    private void setupDatabase() {
        try {
            FileInputStream serviceAccount = new FileInputStream(pathToServiceAccountJson);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(databaseUrl)
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void connectToDatabase() {
        FirebaseApp defaultApp = FirebaseApp.getInstance();
        defaultAuth = FirebaseAuth.getInstance(defaultApp);
        defaultDatabase = FirebaseDatabase.getInstance(defaultApp);
        ref = defaultDatabase.getReference(databaseReference);
    }

    public DatabaseReference getRef() {
        return ref;
    }


}
