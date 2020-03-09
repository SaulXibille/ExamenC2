package com.example.examenc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Encuesta_3 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3, btn_4;
    String respuesta1;
    String respuesta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_3);
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        respuesta1 = bundle.getString("respuesta_1");
        respuesta2 = bundle.getString("respuesta_2");

//        Toast.makeText(this, respuesta1, Toast.LENGTH_SHORT).show();

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_1) {
            Intent ventana = new Intent(this, Encuesta_4.class);
            ventana.putExtra("respuesta_1", respuesta1);
            ventana.putExtra("respuesta_2", respuesta2);
            ventana.putExtra("respuesta_3", "a");
            startActivity(ventana);
        }else if(v == btn_2) {
            Intent ventana = new Intent(this, Encuesta_4.class);
            ventana.putExtra("respuesta_1", respuesta1);
            ventana.putExtra("respuesta_2", respuesta2);
            ventana.putExtra("respuesta_3", "b");
            startActivity(ventana);
        } else if(v == btn_3) {
            Intent ventana = new Intent(this, Encuesta_4.class);
            ventana.putExtra("respuesta_1", respuesta1);
            ventana.putExtra("respuesta_2", respuesta2);
            ventana.putExtra("respuesta_3", "c");
            startActivity(ventana);
        } else if(v == btn_4) {
            Intent ventana = new Intent(this, Encuesta_4.class);
            ventana.putExtra("respuesta_1", respuesta1);
            ventana.putExtra("respuesta_2", respuesta2);
            ventana.putExtra("respuesta_3", "d");
            startActivity(ventana);
        }
    }

//    public void regresar(View view) {
//        try {
//            Intent ventana = new Intent(this, Encuesta1.class);
//            startActivity(ventana);
//        }catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
}
