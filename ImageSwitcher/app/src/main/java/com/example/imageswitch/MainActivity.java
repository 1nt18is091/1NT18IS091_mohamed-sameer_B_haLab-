package com.example.imageswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;
    ImageView img1;
    boolean check;
    int images[]={R.drawable.ghani,R.drawable.random,R.drawable.f1};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=findViewById(R.id.img);
        bt1=findViewById(R.id.next);
        bt2=findViewById(R.id.prev);
        check=true;
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageResource(images[i]);
                i++;
                if(i==3)
                {
                    i=0;
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageResource(images[i]);
                i--;
                if(i==-1)
                {
                    i=2;
                }
            }
        });
    }
}