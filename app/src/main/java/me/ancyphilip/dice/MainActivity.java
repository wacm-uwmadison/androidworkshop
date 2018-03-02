package me.ancyphilip.dice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.num1);
        number2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

    }

    public void add(View view) {
        result.setText(String.valueOf(Double.parseDouble(number1.getText().toString()) + Double.parseDouble(number2.getText().toString())));
    }

    public void sub(View view) {
        result.setText(String.valueOf(Double.parseDouble(number1.getText().toString()) - Double.parseDouble(number2.getText().toString())));

    }

    public void mul(View view) {
        result.setText(String.valueOf(Double.parseDouble(number1.getText().toString()) * Double.parseDouble(number2.getText().toString())));

    }

    public void div(View view) {
        result.setText(String.valueOf(Double.parseDouble(number1.getText().toString()) / Double.parseDouble(number2.getText().toString())));

    }

    public void unitConvert(View view) {
        Intent intent = new Intent(MainActivity.this, UnitConverterActivity.class);
        startActivity(intent);
    }

    public void showWeather(View view){
        Intent intent = new Intent(MainActivity.this, DataFromWebActivity.class);
        startActivity(intent);
    }
}
