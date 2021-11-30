package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    int startTime,stopTime=0;
    int forwardTime,backwardTime=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer media=MediaPlayer.create(this,R.raw.song);
        media.start();
        Button bt1=findViewById(R.id.play);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing Song",Toast.LENGTH_LONG).show();
                media.start();
            }
        });

        Button bt2=findViewById(R.id.pause);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pauing Song",Toast.LENGTH_LONG).show();
                media.pause();
            }
        });

        Button bt3=findViewById(R.id.FSeek);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = media.getCurrentPosition() ;
                if((currentpos+ forwardTime) <= (stopTime = media.getDuration())){
                    media.seekTo(currentpos+forwardTime);
                }
                else
                {
                    media.start();
                }
            }
        });

        Button bt4=findViewById(R.id.BSeek);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = media.getCurrentPosition() ;
                if((currentpos - backwardTime) >= 0){
                    media.seekTo(currentpos-backwardTime);
                }
                else{
                    media.seekTo(0);
                }
            }
        });
        Button bt5=findViewById(R.id.reset);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.reset();
            }
        });
    }
}