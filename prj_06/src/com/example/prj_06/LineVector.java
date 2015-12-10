package com.example.prj_06;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class LineVector extends Line {
    MySurfaceView mySurfaceView;
    int height;
    int width;
    int ox;
    int oy;
    int x;
    int y;
    int z;

    LineVector(MySurfaceView mySurfaceView) {
        this.mySurfaceView = mySurfaceView;
        width = this.mySurfaceView.getWidth();
        height = this.mySurfaceView.getHeight();
        ox = width / 2;
        oy = height / 2;
    }

    @Override
    void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawLine(ox, oy, ox + x * l - z * l, oy - y * l + z * l, paint);
    }

    void setXYZ(int x, int y, int z) {
        this.x = x * 3;
        this.y = y * 3;
        this.z = z * 3;
    }
}
