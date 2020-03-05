package com.example.examenc2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteOpen extends SQLiteOpenHelper {

    public SQLiteOpen(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table resultados(id INTEGER PRIMARY KEY AUTOINCREMENT, preg_1 text, preg_2 text, preg_3 text, preg_4 text, preg_5 text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
