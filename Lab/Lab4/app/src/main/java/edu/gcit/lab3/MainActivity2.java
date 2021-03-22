package edu.gcit.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "edu.gcit.lab3_MESSAGE";
    private TextView mView;
    private TextView mMessageDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mView = findViewById(R.id.textView1);
        mMessageDisplay = findViewById(R.id.Edit_name1);

        Intent obj = getIntent();
        String msg = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mView.setText(msg);
    }
    public void REPLY(View view){
        Intent returnObj = new Intent(this,MainActivity.class);
        String message = mMessageDisplay.getText().toString();
        returnObj.putExtra(String.valueOf(EXTRA_REPLY), message);
        setResult(RESULT_OK, returnObj);
        finish();
    }
}