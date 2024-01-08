package com.example.lasthope;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrackigRrecyclerAdapter extends RecyclerView.Adapter<TrackigRrecyclerAdapter.TrackingHolder>{

    List<Progress> progresses = new ArrayList<>();

    @NonNull
    @Override
    public TrackingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trackingitem, null, false);
        TrackingHolder holder = new TrackingHolder(view);
        return holder;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackigRrecyclerAdapter.TrackingHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TrackingHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView date;
        public TrackingHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.progressionTitle);
            date = itemView.findViewById(R.id.dateProgression);
        }
    }
}


