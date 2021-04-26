package edu.gcit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity.class.getSimpleName()";
    private EditText editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
    }
    public void Website(View view){
        String txt = editText1.getText().toString();
        Uri uri = Uri.parse(txt);
        Intent obj = new Intent(Intent.ACTION_VIEW,uri);

        if (obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit Intent", "Error in Opening website");
        }
    }
    public void Location(View view){
        String location = editText2.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q="+location);
        Intent obj = new Intent(Intent.ACTION_VIEW,uri);
        if (obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit Intent", "Error in Opening website");
        }

    }
    public void Share(View view){
        String text = editText3.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this with:")
                .setText(text)
                .startChooser();
    }
}