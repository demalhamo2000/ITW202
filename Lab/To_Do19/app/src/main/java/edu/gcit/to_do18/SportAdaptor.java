package edu.gcit.to_do18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportAdaptor extends RecyclerView.Adapter<SportAdaptor.ViewHolder> {
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    public SportAdaptor(ArrayList<Sport> mSportsData, Context mContext) {
        this.mSportsData = mSportsData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SportAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdaptor.ViewHolder holder, int position) {
        //get current sport
        Sport currentSport = mSportsData.get(position);
        //populate the TextView with data
        holder.bindTo(currentSport);

    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportImage;

        ViewHolder(View itemView){
            super(itemView);
            mSportImage =(ImageView)itemView.findViewById(R.id.SportImage);
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText =(TextView)itemView.findViewById(R.id.subtitle);
        }
        void bindTo(Sport currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResources()).into(mSportImage);
        }
    }
}
