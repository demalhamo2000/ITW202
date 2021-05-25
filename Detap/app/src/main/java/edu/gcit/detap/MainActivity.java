package edu.gcit.detap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.h1,
    R.drawable.hos1, R.drawable.hos2, R.drawable.hos3, R.drawable.h1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.imageSlider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LPatient:
                Intent obj1 = new Intent(this, PatientLogin.class);
                startActivity(obj1);
                break;
            case R.id.LDoctor:
                Intent obj2 = new Intent(this, DoctorLogin.class);
                startActivity(obj2);
                break;
            case R.id.RDoctor:
                Intent obj3 =new Intent(this, DoctorRegister.class);
                startActivity(obj3);
                break;
            case R.id.RPatient:
                Intent obj4 = new Intent(this, PatientRegister.class);
                startActivity(obj4);
                break;
        }

        }
}