package com.example.examenc2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Encuesta_5 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3;
    String respuesta1;
    String respuesta2;
    String respuesta3;
    String respuesta4;
    String respuesta5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_5);
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        respuesta1 = bundle.getString("respuesta_1");
        respuesta2 = bundle.getString("respuesta_2");
        respuesta3 = bundle.getString("respuesta_3");
        respuesta4 = bundle.getString("respuesta_4");

//        Toast.makeText(this, respuesta1, Toast.LENGTH_SHORT).show();

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_1) {
            respuesta5 = "a";
            confirmar(v);
        }else if(v == btn_2) {
            respuesta5 = "b";
            confirmar(v);
        } else if(v == btn_3) {
            respuesta5 = "c";
            confirmar(v);
        }
    }

//    public void regresar(View view) {
//        Intent ventana = new Intent(this, Encuesta_4.class);
//        startActivity(ventana);
//    }

    public void confirmar(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("ADVERTENCIA");
        builder.setMessage("¿Seguro que quieres guardar la informacion?");

        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                SQLiteOpen admin = new SQLiteOpen(Encuesta_5.this, "encuestas", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();

                ContentValues registro = new ContentValues();
                registro.put("preg_1", respuesta1);
                registro.put("preg_2", respuesta2);
                registro.put("preg_3", respuesta3);
                registro.put("preg_4", respuesta4);
                registro.put("preg_5", respuesta5);


                bd.insert("respuestas", null, registro);
                bd.close();
                Toast.makeText(Encuesta_5.this, "Informacion guardada", Toast.LENGTH_SHORT).show();

                Intent ventana = new Intent(Encuesta_5.this, MainActivity.class);
                startActivity(ventana);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }
}
