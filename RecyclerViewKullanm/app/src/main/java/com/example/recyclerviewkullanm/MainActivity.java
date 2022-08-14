package com.example.recyclerviewkullanm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MeyvelerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.main_activity_recyclerView);
        adapter = new MeyvelerAdapter(Meyveler.getData(), this);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MeyvelerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Meyveler meyveler, int position) {
                Toast.makeText(getApplicationContext(), meyveler.getMeyveIsmi(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}