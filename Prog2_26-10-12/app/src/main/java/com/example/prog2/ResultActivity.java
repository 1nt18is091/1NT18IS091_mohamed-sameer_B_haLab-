package com.example.prog2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        TextView result= (TextView) findViewById(R.id.Result);
        if(extras!=null)
        {
            String tmp = extras.getString("myKey");
            result.setText(tmp);
        }

    }
}