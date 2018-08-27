package com.github.chrisbanes.photoview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

public class RecyclerViewSampleActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewSampleActiv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_sample);

        RecyclerView recyclerView = findViewById(R.id.hacky_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ImageAdapter imageAdapter = new ImageAdapter(new ImageAdapter.Listener() {
            @Override
            public void onImageClicked(View view) {
            }
        },
                                                     true);
        recyclerView.setAdapter(imageAdapter);
        SnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addOnItemTouchListener(new ImagePinchZoomItemTouchListener(this));
    }
}

