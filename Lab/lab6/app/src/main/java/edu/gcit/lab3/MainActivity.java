package edu.gcit.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.lab3_MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    private  EditText mMessageEditTxt;
    private TextView mMessageReceived;
    private TextView mMessageDisplay;
    private Intent data;
    private Bundle outState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");

        mMessageEditTxt = findViewById(R.id.edit_name);
        mMessageReceived = findViewById(R.id.Received_Message);
        mMessageDisplay = findViewById(R.id.Display_Message);

        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                mMessageReceived.setVisibility(View.VISIBLE);
                mMessageDisplay.setText(savedInstanceState
                        .getString("reply_text"));
                mMessageDisplay.setVisibility(View.VISIBLE);
            }

        }
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
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMessageReceived.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",mMessageDisplay.getText().toString());
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }
}