package com.example.prog3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    boolean newOp=true;
    EditText ed1;
    String oldNumber;
    String op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed);

    }

    public void numberEvent(View view){
        if(newOp){
            ed1.setText("");
            newOp=false;
        }
        String number=ed1.getText().toString();
        switch (view.getId()){
            case R.id.number0:
                number+="0";
                break;
            case R.id.number1:
                number+="1";
                break;
            case R.id.number2:
                number+="2";
                break;
            case R.id.number3:
                number+="3";
                break;
            case R.id.number4:
                number+="4";
                break;
            case R.id.number5:
                number+="5";
                break;
            case R.id.number6:
                number+="6";
                break;
            case R.id.number7:
                number+="7";
                break;
            case R.id.number8:
                number+="8";
                break;
            case R.id.number9:
                number+="9";
                break;
            case R.id.dot:
                number+=".";
                break;
            case R.id.slash:
                number="-"+number;
                break;

        }
        ed1.setText(number);
    }
    public void operatorEvent(View view){
        newOp=true;
        oldNumber=ed1.getText().toString();
        switch(view.getId()){
            case R.id.divide:
                op="/";
                break;
            case R.id.sub:
                op="-";
                break;
            case R.id.add:
                op="+";
                break;
            case R.id.mul:
                op="*";
                break;
        }

    }
    public void equalEvent(View view){
        String newNumber=ed1.getText().toString();
        double result=0.0;
        switch(op){
            case "+":
                result=Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result=Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "/":
                result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
            case "*":
                result=Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }
    public void acEvent(View veiw){
        ed1.setText("0");
        newOp=true;
    }

    public void percentEvent(View view){
        double result=Double.parseDouble(ed1.getText().toString());
        ed1.setText(result+"");
        newOp=true;
    }




}