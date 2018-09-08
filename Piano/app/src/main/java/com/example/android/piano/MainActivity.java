package com.example.android.piano;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    int a,b,c,d,e,f,g;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //checking condition i fusing new version of above or equals LoLLIPOP.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).build();

                soundPool = new SoundPool.Builder().setMaxStreams(7).setAudioAttributes(audioAttributes).build();
                //MaxStreams Define how many number you can play at the same tie
            } else {
                soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 1);
            }
            a = soundPool.load(this, R.raw.a, 0);
            b = soundPool.load(this, R.raw.b, 0);
            c = soundPool.load(this, R.raw.c, 0);
            d = soundPool.load(this, R.raw.d, 0);
            e = soundPool.load(this, R.raw.e, 0);
            f = soundPool.load(this, R.raw.f, 0);
            g = soundPool.load(this, R.raw.g, 0);

        }
        public void playMusic(View view){
            switch (view.getId()){
                case R.id.button1:
                    soundPool.play(a,1,1,0,0,1);
                    break;
                case R.id.button2:
                    soundPool.play(b,1,1,0,0,1);
                    break;
                case R.id.button3:
                    soundPool.play(c,1,1,0,0,1);
                    break;
                case R.id.button4:
                    soundPool.play(d,1,1,0,0,1);
                    break;
                case R.id.button5:
                    soundPool.play(e,1,1,0,0,1);
                    break;
                case R.id.button6:
                    soundPool.play(f,1,1,0,0,1);
                    break;
                case R.id.button7:
                    soundPool.play(e,1,1,0,0,1);
                    break;
            }
        }

    }

