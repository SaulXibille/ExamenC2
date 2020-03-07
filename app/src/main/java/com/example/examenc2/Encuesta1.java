package com.example.examenc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Encuesta1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta1);
        getSupportActionBar().hide();
    }

    public void pregunta2(View view) {
        Intent ventana = new Intent(this, Encuesta2.class);
        startActivity(ventana);
    }
}
