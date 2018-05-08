package com.wow.app.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.wow.app.random.adapters.MainAdapter;
import com.wow.app.random.workers.*;

public class MainActivity extends AppCompatActivity {

    private List<String> dataArray;
    private MainAdapter mainAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListeners();

    }

    private void initListeners() {
        findViewById(R.id.button_producer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Producer(dataArray, mainAdapter);
            }
        });
        findViewById(R.id.button_consumer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Consumer(dataArray, mainAdapter);
            }
        });
    }

    private void init() {
        // Setting Up RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataArray = new ArrayList<>();
        mainAdapter = new MainAdapter(dataArray);

        recyclerView.setAdapter(mainAdapter);
    }

}
