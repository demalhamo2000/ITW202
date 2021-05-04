package edu.gcit.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Donut(View view) {
        Toast toast = Toast.makeText(this,R.string.Donut, Toast.LENGTH_SHORT);
        toast.show();

    }

    public void IceCream(View view) {
        Toast toast = Toast.makeText(this, R.string.ice_cream_sandwich, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Froyo(View view) {
        Toast toast = Toast.makeText(this, R.string.froyo, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17390557"));
        startActivity(intent);
    }
}