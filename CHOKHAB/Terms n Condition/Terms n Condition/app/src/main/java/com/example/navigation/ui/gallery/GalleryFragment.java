package com.example.navigation.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
//impoer android.support.v4.app.FramgmentManager;

import com.example.navigation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class GalleryFragment extends Fragment{
   // public static final String EXTRA_MESSAGE = "com.example.navigation.ui.gallery";
   TextView TnC;
    WebView webView;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,}" +                // at least 4 characters
                    "$");

    private FirebaseAuth mAuth;
    private TextView subBut;
    private EditText userName,userAddress,userEmail,password,cPassword,lamid;
    private CheckBox cBox;
    private Spinner uType;
    private ProgressBar progressBar;
    private FragmentActivity myContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_gallery, container, false);

            mAuth = FirebaseAuth.getInstance();

            subBut = (TextView)root.findViewById(R.id.user_submit);
            userName = (EditText)root.findViewById(R.id.user_name);
            userAddress = (EditText)root.findViewById(R.id.user_address);
            userEmail = (EditText)root.findViewById(R.id.user_email);
            password = (EditText)root.findViewById(R.id.user_password);
            cPassword = (EditText)root.findViewById(R.id.user_confpass);
            cBox = (CheckBox)root.findViewById(R.id.checkBox);
            uType =(Spinner)root.findViewById(R.id.occupation);
            lamid = (EditText)root.findViewById(R.id.lam_id);
            progressBar = (ProgressBar)root.findViewById(R.id.progressBar);

            subBut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registration();
                }
            });

            TnC = (TextView) root.findViewById(R.id.TnC);
             TnC.setOnClickListener(new View.OnClickListener(){

                 @Override
                 public void onClick(View v) {
                    TnCFragment secondFragment = new TnCFragment();
                     FragmentTransaction transaction = getFragmentManager().beginTransaction();
                     transaction.replace(R.id.drawer_layout,secondFragment);
                     transaction.commit();
                 }
             });


        return root;
    }



    private void registration() {
        String user_name = userName.getText().toString().trim();
        String user_email = userEmail.getText().toString().trim();
        String user_password = password.getText().toString().trim();
        String user_confpass = cPassword.getText().toString().trim();
        String user_address = userAddress.getText().toString().trim();
        String user_type = uType.getSelectedItem().toString().trim();

        if(user_name.isEmpty()){
            userName.setError("Name cannot be empty");
            userName.requestFocus();
            return;
        }
        if(user_address.isEmpty()) {
            userAddress.setError("Address cannot be empty");
            userAddress.requestFocus();
            return;
        }

        if(user_email.isEmpty()){
            userEmail.setError("Email cannot be empty");
            userEmail.requestFocus();
            return;
        }
        if(user_type.equals("Select user type")){
            TextView errorText = (TextView)uType.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);
            errorText.setText("Select user type");
            return;
        }
        if(user_type.equals("Lam")){
            lamid.setVisibility(View.VISIBLE);
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(user_email).matches()) {
            userEmail.setError("Please provide valid email.");
            userEmail.requestFocus();
            return;
        }
        if(user_password.isEmpty()){
            password.setError("Password is required.");
            password.requestFocus();
            return;
        }

        /*if(user_password.length()<6){
            password.setError("Minimum password length should be 6 characters!.");
            password.requestFocus();
            return;
        }*/
        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        if (!PASSWORD_PATTERN.matcher(user_password).matches()) {
            password.setError("Password is too weak");
            password.requestFocus();
            return;
        }

        if(!user_password.equals(user_confpass)){
            cPassword.setError("Password do not match!");
            cPassword.requestFocus();
            return;
        }
        if(!cBox.isChecked()){
            Toast.makeText(getActivity(),"Check to proceed",Toast.LENGTH_LONG).show();
            //startActivity(new Intent(getActivity(), Terms_Condition.class));
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(user_email,user_password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        User user = new User(user_name,user_address,user_email,user_type);

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){

                                        FirebaseUser User = FirebaseAuth.getInstance().getCurrentUser();

                                        if(User.isEmailVerified()){
                                            Toast.makeText(getActivity(),"Register successful",Toast.LENGTH_LONG).show();
                                            //startActivity(new Intent(getActivity(), dashboard.class));
                                        }else{
                                            User.sendEmailVerification();
                                            Toast.makeText(getActivity(),"Check your email to verify your account!",Toast.LENGTH_LONG).show();
                                        }


                                        progressBar.setVisibility(View.GONE);
                                    }else{
                                        Toast.makeText(getActivity(),"Failed to Register",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                    }else{
                        Toast.makeText(getActivity(),"Failed to register",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }

}
