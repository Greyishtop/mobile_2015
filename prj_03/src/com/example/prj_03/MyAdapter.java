package com.example.prj_03;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

class MyAdapter extends SimpleCursorAdapter {
    Cursor cursor;
    Context context;
    String[] from;
    int[] to;
    DBHelper dbHelper;

    public MyAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags, DBHelper dbHelper) {
        super(context, layout, c, from, to, flags);
        this.context = context;
        this.cursor = c;
        this.from = from;
        this.to = to;
        this.dbHelper = dbHelper;
    }

    class ViewTemp {
        int pos;
        TextView textView;
        int score;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewTemp viewTemp;
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.item, null, true);
            viewTemp = new ViewTemp();
            viewTemp.textView = (TextView) itemView.findViewById(R.id.textView_item);
            itemView.setTag(viewTemp);
        } else {
            viewTemp = (ViewTemp) itemView.getTag();
        }
        if (cursor.moveToPosition(position)) {
            viewTemp.textView.setText(cursor.getString(cursor.getColumnIndex("text")) + " - " + cursor.getInt(cursor.getColumnIndex("done")));
            viewTemp.pos = cursor.getInt(cursor.getColumnIndex("_id"));
        }
        return itemView;
    }
}