package edu.gcit.detap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientRegister extends AppCompatActivity {
    EditText mPName, mPEmail, mPAddress, mPGender, mPNumber, mPPassword;
    Button mP_RegisterBtn;
    TextView mP_LoginBtn1;
    FirebaseAuth fAuth;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        mPName = findViewById(R.id.P_Name);
        mPEmail = findViewById(R.id.P_Email);
        mPAddress = findViewById(R.id.P_Address);
        mPGender = findViewById(R.id.P_Gender);
        mPNumber = findViewById(R.id.P_Number);
        mPPassword = findViewById(R.id.P_Password);
        mP_RegisterBtn = findViewById(R.id.P_Register);
        mP_LoginBtn1 = findViewById(R.id.Login);

        fAuth = FirebaseAuth.getInstance();
        mProgressBar = findViewById(R.id.progressBar);

//        if (fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), DoctorLogin.class));
//            finish();
//        }

        mP_RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mPEmail.getText().toString().trim();
                String password = mPPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mPEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPPassword.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    mPPassword.setError("Password must required more than 6 character");
                    return;
                }

                mProgressBar.setVisibility(View.VISIBLE);

                //register the user in firebase


                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(PatientRegister.this, "User created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), PatientLogin.class));
                        } else {
                            Toast.makeText(PatientRegister.this, "Error !" + task.getException(), Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        mP_LoginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PatientLogin.class));
            }
        });
    }
}