package com.example.examenc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nueva_encuesta(View view) {
        Intent ventana = new Intent(this, Encuesta1.class);
        startActivity(ventana);
    }

}
