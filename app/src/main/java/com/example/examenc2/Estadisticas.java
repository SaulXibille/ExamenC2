package com.example.examenc2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    PieChart pieChart1;

    float p1_a, p1_b, p1_c, p1_d;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        getSupportActionBar().hide();

        try {
            final SQLiteOpen admin = new SQLiteOpen(this, "encuestas", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();

            Cursor tot = bd.rawQuery("select id from respuestas", null);
            total = tot.getCount();
            Toast.makeText(this, "Se entrevistaron a = " + total, Toast.LENGTH_SHORT).show();

            //PREGUNTA 1
            Cursor p_1 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'a'", null);
            p1_a = p_1.getCount();
            p1_a = (p1_a/total)*100;
            Cursor p_2 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'b'", null);
            p1_b = p_2.getCount();
            p1_b = (p1_b/total)*100;
            Cursor p_3 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'c'", null);
            p1_c = p_3.getCount();
            p1_c = (p1_c/total)*100;
            Cursor p_4 = bd.rawQuery("select preg_1 from respuestas where preg_1 = 'd'", null);
            p1_d = p_4.getCount();
            p1_d = (p1_d/total)*100;

            bd.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        pieChart1 = (PieChart)findViewById(R.id.pieChart);
        pieChart1.getDescription().setEnabled(false);
        pieChart1.setDragDecelerationFrictionCoef(0.95f);
        pieChart1.setDrawHoleEnabled(true);
//        pieChart.setUsePercentValues(true);
        pieChart1.setHoleColor(Color.WHITE);
        pieChart1.setDrawHoleEnabled(true);

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(p1_a, "A"));
        entries.add(new PieEntry(p1_b, "B"));
        entries.add(new PieEntry(p1_c, "C"));
        entries.add(new PieEntry(p1_d, "D"));

        PieDataSet pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);

        PieData pieData = new PieData(pieDataSet);

        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.WHITE);
        pieChart1.setData(pieData);

        pieChart1.setCenterText("Califique la atención del personal antes, durante y después de la función.");
        pieChart1.setCenterTextColor(Color.WHITE);
        pieChart1.setHoleColor(Color.parseColor("#2C3D4F"));
        pieChart1.animateXY(2800, 2800);
        pieChart1.invalidate();
    }
}
