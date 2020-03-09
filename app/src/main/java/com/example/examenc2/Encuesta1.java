package com.example.examenc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Encuesta1 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3, btn_4,btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta1);
        getSupportActionBar().hide();

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_volver = (Button)findViewById(R.id.btn_volver);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_volver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_1) {
            Intent ventana = new Intent(this, Encuesta_2.class);
            ventana.putExtra("respuesta_1", "a");
            startActivity(ventana);
        }else if(v == btn_2) {
            Intent ventana = new Intent(this, Encuesta_2.class);
            ventana.putExtra("respuesta_1", "b");
            startActivity(ventana);
        } else if(v == btn_3) {
            Intent ventana = new Intent(this, Encuesta_2.class);
            ventana.putExtra("respuesta_1", "c");
            startActivity(ventana);
        } else if(v == btn_4) {
            Intent ventana = new Intent(this, Encuesta_2.class);
            ventana.putExtra("respuesta_1", "d");
            startActivity(ventana);
        } else if(v == btn_volver){
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }
}
