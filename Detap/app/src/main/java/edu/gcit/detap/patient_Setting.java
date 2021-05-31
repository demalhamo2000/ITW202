package edu.gcit.detap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class patient_Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__setting);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setSelectedItemId(R.id.patient_Setting);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            private MenuItem item;
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.patient_Setting:

                    case R.id.patient_Profile:
                         startActivity(new Intent(getApplicationContext(), patient_Profile.class));
                         finish();
                         overridePendingTransition(0, 0);
                         break;
                    case R.id.patient_DoctorInfo:
                        startActivity(new Intent(getApplicationContext(), patient_DoctorInfo.class));
                        finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.patient_Notification:
                        startActivity(new Intent(getApplicationContext(), patient_Notification.class));
                        finish();
                        overridePendingTransition(0, 0);
                        break;
//                        startActivity(new Intent(getApplicationContext(), patient_Setting.class));
//                        finish();
//                        overridePendingTransition(0, 0);
//                        break;
                }
            }
        });
    }

    public void P_Logout(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}