package com.example.prog2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Num1=(EditText) findViewById(R.id.num1);
        EditText Num2= (EditText) findViewById(R.id.num2);
        Button btn=(Button)findViewById(R.id.button);
        TextView result= (TextView) findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                int n1=Integer.parseInt(Num1.getText().toString());
                int n2=Integer.parseInt(Num2.getText().toString());
                int sum=n1+n2;
//                result.setText(Integer.toString(sum));
                Intent it=new Intent(MainActivity.this,ResultActivity.class);
                it.putExtra("myKey", String.valueOf(sum));
                startActivity(it);
            }
        });
    }
}

//String.valueOf(sum)