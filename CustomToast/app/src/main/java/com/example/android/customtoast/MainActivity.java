package com.example.android.customtoast;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {
    Techniques [] techniques;
    Button button1,button2;
    LayoutInflater layoutInflater;
    View toastLayout;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1= findViewById(R.id.button1);
        button2= findViewById(R.id.button2);

        layoutInflater = getLayoutInflater();

        toastLayout = layoutInflater.inflate(R.layout.custom_layout,(ViewGroup)findViewById(R.id.custom_layout));
        image=toastLayout.findViewById(R.id.image);

    }
    public void simpleToastClick(View view){
        Toast.makeText(this,"Simple Toast ",Toast.LENGTH_SHORT).show();
    }

    public void customToastClick(View view){
        final Toast toast1=Toast.makeText(this,"",Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.BOTTOM,0,0);
        toast1.setView(toastLayout);
        toast1.show();
        YoYo.with(Techniques.Bounce).duration(250).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            //YoYo.with(Techniques.RollOut).duration(2500).playOn(image);
                YoYo.with(Techniques.RollIn).duration(1000).playOn(image);

            }

            @Override
            public void onAnimationEnd(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).playOn(toastLayout);
    }


}
