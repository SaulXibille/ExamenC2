package com.example.examenc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Encuesta5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta5);
        getSupportActionBar().hide();
    }

    /*public void inicio(View view) {
        Intent ventana = new Intent(this, MainActivity.class);
        startActivity(ventana);
    }*/
}
