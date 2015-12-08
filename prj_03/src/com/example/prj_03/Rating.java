package com.example.prj_03;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Rating extends Activity implements View.OnClickListener {
    DBHelper dbHelper;
    MyAdapter adapter;
    ListView listView;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);
        dbHelper = new DBHelper(this);
        listView = (ListView) findViewById(R.id.listView);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        write();
        readFromDB();
    }

    void write() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("text", "Name");
        cv.put("done", 0);
        db.insert("rating", null, cv);
        dbHelper.close();
    }

    void readFromDB() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("rating", null, null, null, null, null, null);
        adapter = new MyAdapter(
                this,
                R.layout.item,
                c,
                new String[]{"text"},
                new int[]{R.id.textView_item},
                0,
                dbHelper
        );
        listView.setAdapter(adapter);
        dbHelper.close();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}
