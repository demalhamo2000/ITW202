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

public class PatientLogin extends AppCompatActivity {
    EditText mPEmail, mPPassword;
    TextView mP_RegisterBtn;
    Button mP_LoginBtn;
    FirebaseAuth fAuth;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        mPEmail = findViewById(R.id.PLogEmail);
        mPPassword = findViewById(R.id.PLogPass);
        mP_LoginBtn = findViewById(R.id.PLogin);
        mP_RegisterBtn = findViewById(R.id.Pregister);

        fAuth = FirebaseAuth.getInstance();
        mProgressBar = findViewById(R.id.progressBar);

        mP_LoginBtn.setOnClickListener(new View.OnClickListener() {
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


                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(PatientLogin.this,"Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), DoctorHome.class));
                        } else {
                            Toast.makeText(PatientLogin.this,"Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        mP_RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PatientRegister.class));
            }
        });

    }

}