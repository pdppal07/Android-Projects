package com.example.android.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Button pre,next;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pre=findViewById(R.id.pre);
        //next=findViewById(R.id.next);

        viewPager = findViewById(R.id.viewpager);

        pager p = new pager(getSupportFragmentManager());
        p.addFragment(first.newInstance());
        //p.addFragment(second.newInstance());
        //p.addFragment(third.newInstance());

        viewPager.setAdapter(p);
        /*//first button
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                Fragment sec = first.newInstance();
                fragmentTransaction.replace(R.id.frame,sec);
                fragmentTransaction.commit();
            }
        });

        //second button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                Fragment sec = second.newInstance();
                fragmentTransaction.replace(R.id.frame,sec);
                fragmentTransaction.commit();
            }
        });*/
    }
}