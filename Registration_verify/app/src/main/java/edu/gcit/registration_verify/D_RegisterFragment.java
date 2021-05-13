package edu.gcit.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class D_RegisterFragment extends Fragment {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&++])"+ //at least 1 special character
                    "(?=\\S+$)"+        //no white spaces
                    ".{6,}"+            //at least 4 characters
                    "$");

    // private FirebaseAuth mAuth;
    private TextView mBut;
    private EditText mD_Name,mD_Email,mD_Id, mD_Pass,mD_Department,mD_Chamber,mD_Phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_d__register, container, false);
       // mBut = (TextView) root.findViewById(R.id.Register);
        mD_Name = (EditText) root.findViewById(R.id.P_Name);
        mD_Chamber = (EditText) root.findViewById(R.id.P_Gender);
        mD_Department = (EditText) root.findViewById(R.id.P_Address);
        mD_Email = (EditText) root.findViewById(R.id.P_Email);
        mD_Id =(EditText) root.findViewById(R.id.D_id);
        mD_Pass =(EditText) root.findViewById(R.id.P_Password);
        mD_Phone = (EditText) root.findViewById(R.id.P_Number);

        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });

        return root;
    }
    private void registration() {
        String D_name = mD_Name.getText().toString().trim();
        String D_Email = mD_Email.getText().toString().trim();
        String D_Department = mD_Department.getText().toString().trim();
        String D_Chamber = mD_Chamber.getText().toString().trim();
        String D_Id = mD_Id.getText().toString().trim();
        String D_Number = mD_Phone.getText().toString().trim();
        String D_Password = mD_Pass.getText().toString().trim();

        if (D_name.isEmpty()) {
            mD_Name.setError("Name cannot be empty");
            mD_Name.requestFocus();
            return;
        }
        if (D_Email.isEmpty()) {
            mD_Email.setError("Email cannot be empty");
            mD_Email.requestFocus();
            return;
        }
        if (D_Department.isEmpty()) {
            mD_Department.setError("Department name cannot be empty");
            mD_Department.requestFocus();
            return;
        }
        if (D_Chamber.isEmpty()) {
            mD_Chamber.setError("Chamber number cannot be empty");
            mD_Chamber.requestFocus();
            return;
        }
        if (D_Number.isEmpty()) {
            mD_Phone.setError("Phone number cannot be empty");
            mD_Phone.requestFocus();
            return;
        }
        if (D_Id.isEmpty()) {
            mD_Id.setError("Your Id cannot be empty");
            mD_Id.requestFocus();
            return;
        }
        if (D_Password.isEmpty()) {
            mD_Pass.setError("Password cannot be empty");
            mD_Pass.requestFocus();
            return;
        }

//        if (!EMAIL_ADDRESS.matcher(D_Email).matches()){
//            mD_Email.setError("Please provide valid email");
//            mD_Email.requestFocus();
//            return;
//        }
        if (!PASSWORD_PATTERN.matcher(D_Password).matches()) {
            mD_Pass.setError("Password is too weak");
            mD_Pass.requestFocus();
            return;
        }
    }
}