package edu.gcit.to_do16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdaptor extends RecyclerView.Adapter<WordListAdaptor.WordViewHolder>{
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdaptor(Context context,LinkedList<String> mWordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordListAdaptor.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.word_list, parent,false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdaptor.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView wordItemView;
        final WordListAdaptor mAdapter;

        public WordViewHolder(View itemView,WordListAdaptor mAdapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition,"Clicked!"+element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
