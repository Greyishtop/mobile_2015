package com.example.prj_03;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper {
    String nameTable;

    public DBHelper(Context context) {
        super(context, "tasks.db", null, 1);
        this.nameTable = nameTable;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table rating ("
                + "_id integer primary key autoincrement,"
                + "text text not null,"
                + "done int" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}