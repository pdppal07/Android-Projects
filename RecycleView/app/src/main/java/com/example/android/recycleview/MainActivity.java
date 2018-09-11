package com.example.android.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class      MainActivity extends AppCompatActivity {
    int [] images={R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,
            R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,R.drawable.food11,
            R.drawable.food12};
    String [] np={"Roll:100","Cake:60","Rusgulla:50","Pestry:20",
            "paties:60","Momo:167","Parthe:100","Roll:100","Roll:100",
            "Roll:100","Roll:100","Roll:100"};
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rec);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setAdapter(new Rcadapter(MainActivity.this,images,np));
    }
}
