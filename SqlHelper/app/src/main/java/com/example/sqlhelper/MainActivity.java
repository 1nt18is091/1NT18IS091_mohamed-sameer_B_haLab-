package com.example.sqlhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edUserName=findViewById(R.id.userName);
        EditText edUserPassword=findViewById(R.id.password);
        EditText edFullName=findViewById(R.id.name);
        Button btnLogin=findViewById(R.id.logBtn);
        DatabaseHelper dbh=new DatabaseHelper(getApplicationContext());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User userObj=new User(edUserName.getText().toString(),edUserPassword.getText().toString(),edFullName.getText().toString());
                
                if(dbh.InsertUser(userObj)){
                    Toast.makeText(getApplicationContext(), "Your details were saved succesfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Sorry Failed to save your details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}