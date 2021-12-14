package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    String teamList[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=findViewById(R.id.list);
        teamList=getResources().getStringArray(R.array.f1Teams);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,teamList);
        myList.setAdapter(arrayAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have Clicked"+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}