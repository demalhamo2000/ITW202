package edu.gcit.detap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class D_Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d__setting);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.doctorNavigation);
        bottomNavigationView.setSelectedItemId(R.id.D_Setting);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            private MenuItem item;
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.D_Profile:
                         startActivity(new Intent(getApplicationContext(), D_Profile.class));
                         finish();
                         overridePendingTransition(0, 0);
                         break;
                    case R.id.D_PatientList:
                        startActivity(new Intent(getApplicationContext(), D_PatientList.class));
                        finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.D_Notification:
                        startActivity(new Intent(getApplicationContext(), D_Notification.class));
                        finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.D_Setting:
//                        startActivity(new Intent(getApplicationContext(), patient_Setting.class));
//                        finish();
//                        overridePendingTransition(0, 0);
//                        break;
                }
            }
        });
    }
}