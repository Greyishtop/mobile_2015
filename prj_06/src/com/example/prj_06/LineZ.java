package com.example.prj_06;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class LineZ extends Line {
    MySurfaceView mySurfaceView;
    int height;
    int width;
    int ox;
    int oy;

    LineZ(MySurfaceView mySurfaceView) {
        this.mySurfaceView = mySurfaceView;
        width = this.mySurfaceView.getWidth();
        height = this.mySurfaceView.getHeight();
        ox = width / 2;
        oy = height / 2;
    }

    @Override
    void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawLine(ox, oy, ox - 15 * l, oy + 15 * l, paint);
    }
}
