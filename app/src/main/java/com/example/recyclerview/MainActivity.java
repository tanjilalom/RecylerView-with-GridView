package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] img = {
            R.drawable.argentina, R.drawable.bangladesh, R.drawable.brazil, R.drawable.india,
            R.drawable.netherlands, R.drawable.pakistan, R.drawable.united_kingdom,
            R.drawable.united_states_of_america,
    };

    MyAdapter myAdapter;
    String [] title, des;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleviewid);
        title = getResources().getStringArray(R.array.country_Names);
        des = getResources().getStringArray(R.array.country_des);


        myAdapter = new MyAdapter(this, title, des, img);

        recyclerView.setAdapter(myAdapter);

        int spanCount = 3;
        GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);
        recyclerView.setLayoutManager(layoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));



        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(MainActivity.this, "onItemClick: "+ position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(MainActivity.this, "onItemLongClick: "+ position, Toast.LENGTH_SHORT).show();

            }
        });

    }
}