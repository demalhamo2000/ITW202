package edu.gcit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mText;
    public String[] mColorArray = {"black","white", "red", "blue",
            "lightBlue", "lime", "grey", "maroon", "rose"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.textView);
    }

    public void ChangeColor(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(9)];

        int colorResourceName = getResources().getIdentifier(colorName,"color" ,
                getApplicationContext().getPackageName());

        int colorRes = ContextCompat.getColor(this,colorResourceName);
        mText.setTextColor(colorRes);
    }
}