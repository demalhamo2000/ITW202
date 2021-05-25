package edu.gcit.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.lab3_MESSAGE";
    public static final int TEXT_REQUEST = 1;


    private  EditText mMessageEditTxt;
    private TextView mMessageReceived;
    private TextView mMessageDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditTxt = findViewById(R.id.edit_name);
        mMessageReceived = findViewById(R.id.Received_Message);
        mMessageDisplay = findViewById(R.id.Display_Message);
    }
    public void Next(View view){
        Intent obj = new Intent(this,MainActivity2.class);
        String message = mMessageEditTxt.getText().toString();
        obj.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(obj, TEXT_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String Reply = data.getStringExtra(String.valueOf(MainActivity2.EXTRA_REPLY));
                mMessageReceived.setVisibility(View.VISIBLE);
                mMessageDisplay.setText(Reply);
                mMessageDisplay.setVisibility(View.VISIBLE);
            }
        }
    }
}