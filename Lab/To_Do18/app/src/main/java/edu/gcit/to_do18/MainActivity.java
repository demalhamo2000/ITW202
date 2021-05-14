package edu.gcit.to_do18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private ArrayList<Sport> mSportData;
    private SportAdaptor mAdapter;
    private ImageView mSportImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView=(RecyclerView)findViewById(R.id.ReCycleView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));


        mSportData = new ArrayList<>();
        //Initialize the adapter and set it at the recycleview

        mAdapter = new SportAdaptor(mSportData,this);
        mRecycleView.setAdapter(mAdapter);

        //get the data
        initializeData();
    }
    private void initializeData(){
        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.sport_images);
        String[] sportList = getResources().getStringArray(R.array.sport_title);
        String[] sportInfo = getResources().getStringArray(R.array.Sport_info);
        mSportData.clear();

        for (int i=0;i<sportList.length;i++){
            mSportData.add(new Sport(sportList[i],sportInfo[i],sportImageResources.getResourceId(i,0)));
        }
        mAdapter.notifyDataSetChanged();
        sportImageResources.recycle();
    }
}