package com.example.DATABASE;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class AddListActivity extends Activity {
    EditText field;
    Button button;
    DatabaseHelper db;
    ArrayList<Task> adapterlist;
    Intent intent;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.addactivity);
        field = (EditText) findViewById(R.id.entertaskfield);
        button = (Button) findViewById(R.id.insertTask);
        db = new DatabaseHelper(this);
        intent = getIntent();
    }

    public void onClickAdd(View view) {
        if (!field.getText().toString().equals("Ввод") && !field.getText().toString().equals("")) {
            String c = field.getText().toString().substring(0, 1).toUpperCase() + field.getText().toString().substring(1);
            Intent intent = new Intent();
            db.insertList(c);
            Cursor cursor = db.getReadableDatabase().rawQuery("select last_insert_rowid()", null);
            cursor.moveToFirst();
            int _id = cursor.getInt(0);
            List list = new List(_id, c);
            Toast toast = Toast.makeText(getApplicationContext(), "Список \"" + list.text + "\"успешно  добавлен", Toast.LENGTH_LONG);
            toast.show();
            intent.putExtra("list", list);
            setResult(MainActivity.ADDED, intent);
            finish();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.enterexception, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void onClickOnField(View view) {
        field.setTextColor(0xFFFFFFFF);
        field.setText("");
    }
}













