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

public class DoctorLogin extends AppCompatActivity {

    EditText mDEmail, mDPassword;
    Button mD_LoginBtn;
    TextView mD_registerBtn;
    FirebaseAuth fAuth;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

       mDEmail = findViewById(R.id.DLogEmail);
       mDPassword = findViewById(R.id.DLogPass);
       mD_LoginBtn = findViewById(R.id.DLogin);
       mD_registerBtn = findViewById(R.id.register);

       fAuth = FirebaseAuth.getInstance();
       mProgressBar = findViewById(R.id.progressBar);

       mD_LoginBtn.setOnClickListener(new View.OnClickListener() {
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
               //Authenticate the user

               fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(DoctorLogin.this,"Logged in Successfully", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(), DoctorHome.class));
                       } else {
                           Toast.makeText(DoctorLogin.this,"Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           mProgressBar.setVisibility(View.GONE);
                       }
                   }
               });
           }
       });
       mD_registerBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), DoctorRegister.class));
           }
       });

    }


}