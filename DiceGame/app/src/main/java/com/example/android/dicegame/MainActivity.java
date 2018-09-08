package com.example.android.dicegame;


import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.fading_entrances.FadeInAnimator;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    int i;
    ImageView imageView;
    Random random = new Random();
    Techniques[] techniques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new RotateAnimation(0,720,imageView.getWidth()/2,imageView.getHeight()/2);
                animation.setDuration(1500);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        imageView.setImageResource(R.drawable.dic);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        rollDice();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageView.startAnimation(animation);

            }
        });



        YoYo.with(Techniques.Hinge).duration(2500).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
              //  YoYo.with(Techniques.RotateInDownLeft).duration(2000).playOn(imageView);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                YoYo.with(Techniques.RotateInDownLeft).duration(5000).playOn(imageView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                YoYo.with(Techniques.FadeIn).duration(1500).playOn(imageView);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                YoYo.with(Techniques.RotateInDownLeft).duration(2000).playOn(imageView);
            }
        }).playOn(imageView);

    }



    public void rollDice(){
        int randomnumber = random.nextInt(6)+1;

        switch (randomnumber){
            case 1:imageView.setImageResource(R.drawable.dice1);
                break;
            case 2:imageView.setImageResource(R.drawable.dice2);
                break;
            case 3:imageView.setImageResource(R.drawable.dice3);
                break;
            case 4:imageView.setImageResource(R.drawable.dice4);
                break;
            case 5:imageView.setImageResource(R.drawable.dice5);
                break;
            case 6:imageView.setImageResource(R.drawable.dice6);
                break;

        }

    }
}
