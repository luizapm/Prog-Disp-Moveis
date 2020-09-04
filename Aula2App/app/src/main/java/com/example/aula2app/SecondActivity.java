package com.example.aula2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Double celsius = intent.getDoubleExtra("valorPassado", 0);

        //calculos
        Double resFinal = ((celsius*9)/5)+32;

        TextView textView = findViewById(R.id.txtResultado);
        textView.setText(String.format(resFinal.toString(), "%.2f"));

    }
}