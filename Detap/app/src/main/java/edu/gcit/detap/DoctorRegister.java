package edu.gcit.detap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class DoctorRegister extends AppCompatActivity {
    EditText mDName, mDEmail, mDepartment, mChamber, mDNumber, mDId, mDPassword;
    Button mD_RegisterBtn;
    TextView mD_LoginBtn1;
    FirebaseAuth fAuth;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        mDName = findViewById(R.id.D_Name);
        mDEmail = findViewById(R.id.D_Email);
        mDepartment = findViewById(R.id.D_Department);
        mChamber = findViewById(R.id.D_Chamber);
        mDNumber = findViewById(R.id.D_Number);
        mDId = findViewById(R.id.D_id);
        mDPassword = findViewById(R.id.D_Password);
        mD_RegisterBtn = findViewById(R.id.D_Register);
        mD_LoginBtn1 = findViewById(R.id.Login);

        fAuth = FirebaseAuth.getInstance();
        mProgressBar = findViewById(R.id.progressBar);

//        if (fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), DoctorLogin.class));
//            finish();
//        }

        mD_RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mDEmail.getText().toString().trim();
                String password = mDPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mDEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mDPassword.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    mDPassword.setError("Password must required more than 6 character");
                    return;
                }

                mProgressBar.setVisibility(View.VISIBLE);

                //register the user in firebase


                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DoctorRegister.this, "User created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), DoctorLogin.class));
                        } else {
                            Toast.makeText(DoctorRegister.this, "Error !" + task.getException(), Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        mD_LoginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DoctorLogin.class));
            }
        });
    }
}



