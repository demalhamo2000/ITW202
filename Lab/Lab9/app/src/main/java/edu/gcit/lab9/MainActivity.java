package edu.gcit.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEdit1;
    private EditText mEdit2;
    private TextView mTextView1;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mEdit1 = findViewById(R.id.edit1);
        mEdit2 = findViewById(R.id.edit2);
        mTextView1 = findViewById(R.id.textView1);
    }
    public void Addition(View view){
        String Val1 = mEdit1.getText().toString();
        String Val2 = mEdit2.getText().toString();
        double mResult = mCalculator.Add(Double.valueOf(Val1), Double.valueOf(Val2));
        mTextView1.setText(String.valueOf(mResult));

        Log.d("Debugging", "Hello Debug");
    }
    public void Subtraction(View view){
        String Val1 = mEdit1.getText().toString();
        String Val2 = mEdit2.getText().toString();
        double mResult = mCalculator.Sub(Double.valueOf(Val1), Double.valueOf(Val2));
        mTextView1.setText(String.valueOf(mResult));

        Log.d("Debugging", "Hello Debug");
                
    }
    public void Multiplication(View view){
        String Val1 = mEdit1.getText().toString();
        String Val2 = mEdit2.getText().toString();
        double mResult = mCalculator.Mul(Double.valueOf(Val1), Double.valueOf(Val2));
        mTextView1.setText(String.valueOf(mResult));

        Log.d("Debugging", "Hello Debug");

    }
    public void Division(View view){
        String Val1 = mEdit1.getText().toString();
        String Val2 = mEdit2.getText().toString();
        double mResult = mCalculator.Div(Double.valueOf(Val1), Double.valueOf(Val2));
        mTextView1.setText(String.valueOf(mResult));

        Log.d("Debugging", "Hello Debug");

    }
}