package com.example.examenc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity implements View.OnClickListener{

    PieChart pieChart1;
    PieChart pieChart2;
    PieChart pieChart3;
    PieChart pieChart4;
    PieChart pieChart5;


    float p1_a, p1_b, p1_c, p1_d;
    float p2_a, p2_b, p2_c, p2_d;
    float p3_a, p3_b, p3_c, p3_d;
    float p4_a, p4_b, p4_c, p4_d;
    float p5_a, p5_b, p5_c;
    int total;

    private Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        getSupportActionBar().hide();

        pieChart1 = (PieChart)findViewById(R.id.pieChart);
        pieChart2 = (PieChart)findViewById(R.id.pieChart2);
        pieChart3 = (PieChart)findViewById(R.id.pieChart3);
        pieChart4 = (PieChart)findViewById(R.id.pieChart4);
        pieChart5 = (PieChart)findViewById(R.id.pieChart5);

        btn_volver = (Button)findViewById(R.id.btn_volver);
        btn_volver.setOnClickListener(this);

        try {
            final SQLiteOpen admin = new SQLiteOpen(this, "encuestas", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();

            Cursor tot = bd.rawQuery("select id from respuestas", null);
            total = tot.getCount();
            Toast.makeText(this, "Se entrevistaron a = " + total, Toast.LENGTH_SHORT).show();

            //PREGUNTA 1
            Cursor p1_1 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'a'", null);
            p1_a = p1_1.getCount();
            p1_a = (p1_a/total)*100;
            Cursor p1_2 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'b'", null);
            p1_b = p1_2.getCount();
            p1_b = (p1_b/total)*100;
            Cursor p1_3 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'c'", null);
            p1_c = p1_3.getCount();
            p1_c = (p1_c/total)*100;
            Cursor p1_4 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'd'", null);
            p1_d = p1_4.getCount();
            p1_d = (p1_d/total)*100;

            //PREGUNTA 2
            Cursor p2_1 = bd.rawQuery("select preg_2 from respuestas where preg_2 = 'a'", null);
            p2_a = p2_1.getCount();
            p2_a = (p2_a/total)*100;
            Cursor p2_2 = bd.rawQuery("select preg_2 from respuestas where preg_2 = 'b'", null);
            p2_b = p2_2.getCount();
            p2_b = (p2_b/total)*100;
            Cursor p2_3 = bd.rawQuery("select preg_2 from respuestas where preg_2 = 'c'", null);
            p2_c = p2_3.getCount();
            p2_c = (p2_c/total)*100;
            Cursor p2_4 = bd.rawQuery("select preg_2 from respuestas where preg_2 = 'd'", null);
            p2_d = p2_4.getCount();
            p2_d = (p2_d/total)*100;

            //PREGUNTA 3
            Cursor p3_1 = bd.rawQuery("select preg_3 from respuestas where preg_3 = 'a'", null);
            p3_a = p3_1.getCount();
            p3_a = (p3_a/total)*100;
            Cursor p3_2 = bd.rawQuery("select preg_3 from respuestas where preg_3 = 'b'", null);
            p3_b = p3_2.getCount();
            p3_b = (p3_b/total)*100;
            Cursor p3_3 = bd.rawQuery("select preg_3 from respuestas where preg_3 = 'c'", null);
            p3_c = p3_3.getCount();
            p3_c = (p3_c/total)*100;
            Cursor p3_4 = bd.rawQuery("select preg_3 from respuestas where preg_3 = 'd'", null);
            p3_d = p3_4.getCount();
            p3_d = (p3_d/total)*100;

            //PREGUNTA 4
            Cursor p4_1 = bd.rawQuery("select preg_4 from respuestas where preg_4 = 'a'", null);
            p4_a = p4_1.getCount();
            p4_a = (p4_a/total)*100;
            Cursor p4_2 = bd.rawQuery("select preg_4 from respuestas where preg_4 = 'b'", null);
            p4_b = p4_2.getCount();
            p4_b = (p4_b/total)*100;
            Cursor p4_3 = bd.rawQuery("select preg_4 from respuestas where preg_4 = 'c'", null);
            p4_c = p4_3.getCount();
            p4_c = (p4_c/total)*100;
            Cursor p4_4 = bd.rawQuery("select preg_4 from respuestas where preg_4 = 'd'", null);
            p4_d = p4_4.getCount();
            p4_d = (p4_d/total)*100;

            //PREGUNTA 5
            Cursor p5_1 = bd.rawQuery("select preg_5 from respuestas where preg_5 = 'a'", null);
            p5_a = p5_1.getCount();
            p5_a = (p5_a/total)*100;
            Cursor p5_2 = bd.rawQuery("select preg_5 from respuestas where preg_5 = 'b'", null);
            p5_b = p5_2.getCount();
            p5_b = (p5_b/total)*100;
            Cursor p5_3 = bd.rawQuery("select preg_5 from respuestas where preg_5 = 'c'", null);
            p5_c = p5_3.getCount();
            p5_c = (p5_c/total)*100;

            bd.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        ArrayList<PieEntry> entries1 = new ArrayList<>();
        entries1.add(new PieEntry(p1_a, "A"));
        entries1.add(new PieEntry(p1_b, "B"));
        entries1.add(new PieEntry(p1_c, "C"));
        entries1.add(new PieEntry(p1_d, "D"));

        ArrayList<PieEntry> entries2 = new ArrayList<>();
        entries2.add(new PieEntry(p2_a, "A"));
        entries2.add(new PieEntry(p2_b, "B"));
        entries2.add(new PieEntry(p2_c, "C"));
        entries2.add(new PieEntry(p2_d, "D"));

        ArrayList<PieEntry> entries3 = new ArrayList<>();
        entries3.add(new PieEntry(p3_a, "A"));
        entries3.add(new PieEntry(p3_b, "B"));
        entries3.add(new PieEntry(p3_c, "C"));
        entries3.add(new PieEntry(p3_d, "D"));

        ArrayList<PieEntry> entries4 = new ArrayList<>();
        entries4.add(new PieEntry(p4_a, "A"));
        entries4.add(new PieEntry(p4_b, "B"));
        entries4.add(new PieEntry(p4_c, "C"));
        entries4.add(new PieEntry(p4_d, "D"));

        ArrayList<PieEntry> entries5 = new ArrayList<>();
        entries5.add(new PieEntry(p5_a, "A"));
        entries5.add(new PieEntry(p5_b, "B"));
        entries5.add(new PieEntry(p5_c, "C"));

        grafica(entries1, pieChart1);
        grafica(entries2, pieChart2);
        grafica(entries3, pieChart3);
        grafica(entries4, pieChart4);
        grafica(entries5, pieChart5);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_volver) {
            Intent ventana = new Intent(this, MainActivity.class);
            startActivity(ventana);
        }
    }

    public void grafica(ArrayList<PieEntry> entries, PieChart pieChart){
        pieChart.getDescription().setEnabled(false);
        pieChart.setDragDecelerationFrictionCoef(2f);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(30f);
        pieChart.setHoleRadius(25f);

        PieDataSet pieDataSet = new PieDataSet(entries,"");
        pieDataSet.setSelectionShift(3.5f);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(14f);
        pieDataSet.setSliceSpace(5f);


        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(17f);
        pieData.setValueTextColor(Color.WHITE);
        pieData.setValueFormatter(new PercentFormatter());

        pieChart.setData(pieData);
        pieChart.setUsePercentValues(true);

        pieChart.setHoleColor(Color.parseColor("#2C3D4F"));
        pieChart.animateXY(2800, 2800);
        pieChart.invalidate();
    }
}
