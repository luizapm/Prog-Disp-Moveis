package com.example.aula2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Olá!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "A execução está no onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "A execução está no onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "A execução está no onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "A execução está no onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "A execução está no onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "A execução está no onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "A execução está no onDestroy");
    }

    public void abrirClick(View view) {
        EditText editText = findViewById(R.id.idCelsius);
        Double celsius = Double.parseDouble(editText.getText().toString().replace(",", "."));

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("valorPassado", celsius);
        startActivity(intent);
    }
}