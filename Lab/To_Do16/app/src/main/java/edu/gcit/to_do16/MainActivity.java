package edu.gcit.to_do16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;


    private final LinkedList<String> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i<20; i++){
            mWordList.addLast("Word"+i);
        }
        mRecycleView = findViewById(R.id.recycleview);
        WordListAdaptor mAdapter = new WordListAdaptor(this, mWordList);
        mRecycleView.setAdapter(mAdapter);
        LinearLayoutManager obj = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(obj);

        FloatingActionButton Fab = findViewById(R.id.floatingActionButton);
        Fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                //add a new word to the wordlist.
                mWordList.addLast("+word"+wordListSize);
                //notify the adaptor, that the data is changed.
                mRecycleView.getAdapter().notifyItemInserted(wordListSize);
                //Scroll to the button
                mRecycleView.smoothScrollToPosition(wordListSize);
            }
        });

    }
}