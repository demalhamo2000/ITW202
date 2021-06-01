package edu.gcit.lab25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mFName, mLName, mMark, mID;
    DatabaseHelper myDB;
    Button mBtnAdd, mBtnView, mBtnUpdate, mBtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFName = findViewById(R.id.firstName);
        mLName = findViewById(R.id.lastName);
        mMark = findViewById(R.id.mark);
        mID = findViewById(R.id.ID);
        mBtnAdd = findViewById(R.id.button);
        mBtnView = findViewById(R.id.button2);
        mBtnUpdate = findViewById(R.id.button3);
        mBtnDelete = findViewById(R.id.button4);

        myDB = new DatabaseHelper(this);
    }

    public void AddData(View view) {
        boolean isInserted = myDB.insertData(mID.getText().toString(),
                mFName.getText().toString(), mLName.getText().toString(), mMark.getText().toString());
        if (isInserted == true) {
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
    public void ViewDetails(View view) {
        Cursor res = myDB.getAllData();
        if (res.getCount() == 0){
            showMessage("error", "Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Student id : "+res.getString(0)+"\n");
            buffer.append("First Name: "+res.getString(1)+"\n");
            buffer.append("Last Name: "+res.getString(2)+"\n");
            buffer.append("ITW202 Marks: "+res.getString(3)+"\n\n");

        }
        //show all data
        showMessage("List of the student",buffer.toString());
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void Update(View view) {
        boolean isUpdate = myDB.upDateData(mID.getText().toString(),
                mFName.getText().toString(), mLName.getText().toString(), mMark.getText().toString());
        if (isUpdate == true) {
            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
        }
    }

    public void Delete(View view) {
        Integer deletedRows = myDB.deleteData(mID.getText().toString());
        if (deletedRows > 0) {
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}