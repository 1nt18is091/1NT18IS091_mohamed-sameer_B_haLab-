package com.example.sqlhelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
        Button btnUpdate=findViewById(R.id.updateBtn);
        Button btnDelete=findViewById(R.id.deleteBtn);
        Button btnView=findViewById(R.id.viewBtn);

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

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User userObj=new User(edUserName.getText().toString(),edUserPassword.getText().toString(),edFullName.getText().toString());

                if(dbh.updateData(userObj)){
                    Toast.makeText(getApplicationContext(), "Your details were updated succesfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Sorry Failed to Update your details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=dbh.viewData();
                if(res.getCount()==0){
                    Toast.makeText(getApplicationContext(), "No record Exist", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer buffer =new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("Username:"+res.getString(0)+"\n");
                        buffer.append("Password:"+res.getString(1)+"\n");
                        buffer.append("Full Name:"+res.getString(2)+"\n");
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Data");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });
    }
}