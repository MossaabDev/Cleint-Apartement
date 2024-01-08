package com.example.lasthope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ConstructionTracking extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    TrackigRrecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction_tracking);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Progress Tracking");
        List<Progress> progresses = new ArrayList<>();
        progresses.add(new Progress("Site Preparation:", "12-06-2022 16:30"));
        progresses.add(new Progress("Roofing:", "23-11-2022 16:30"));
        progresses.add(new Progress("Interior Work", "31-02-2023"));
        adapter = new TrackigRrecyclerAdapter();
        adapter.setProgresses(progresses);
        adapter.notifyDataSetChanged();
        recyclerView = findViewById(R.id.recyclerViewProduction);

    }
}