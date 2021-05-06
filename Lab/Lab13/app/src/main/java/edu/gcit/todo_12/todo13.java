package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class todo13 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    private TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo13);
        tview = findViewById(R.id.msg);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MSG);
        tview.setText(msg);
        spinner = findViewById(R.id.spinnermain);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerDdown, R.layout.support_simple_spinner_dropdown_item);
        if(spinner!=null){
            spinner.setAdapter(adapter);
        }
    }

    public void radiobtn(View view) {
        boolean isChecked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.sameday:
                displayToast(getString(R.string.rb1));
                break;

            case R.id.nextday:
                displayToast(getString(R.string.rb2));
                break;
            case R.id.pickup:
                displayToast(getString(R.string.rb3));
                break;
            default:
                break;
        }
    }



    public void displayToast(String msg){
        Toast.makeText(getApplicationContext(),msg,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sMsg = parent.getItemAtPosition(position).toString();
        displayToast(sMsg);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }
}