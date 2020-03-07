package com.example.examenc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class Encuesta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta2);
        getSupportActionBar().hide();
    }

    public void pregunta3(View view) {
        Intent ventana = new Intent(this, Encuesta3.class);
        startActivity(ventana);
    }

}
