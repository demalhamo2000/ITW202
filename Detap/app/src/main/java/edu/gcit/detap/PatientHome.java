 package edu.gcit.detap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PatientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        ButtomNavigationView buttomNavigationView = findViewById(R.id.bottomNavigationView2);
    }
}