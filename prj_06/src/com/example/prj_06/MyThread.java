package com.example.prj_06;

import android.graphics.Canvas;
import android.graphics.Color;

public class MyThread extends Thread {
    MySurfaceView mySurfaceView;

    public MyThread(MySurfaceView mySurfaceView) {
        this.mySurfaceView = mySurfaceView;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (true) {
            canvas = mySurfaceView.getHolder().lockCanvas();
            canvas.drawColor(Color.WHITE);
            mySurfaceView.render(canvas);
            mySurfaceView.getHolder().unlockCanvasAndPost(canvas);
            try {
                Thread.sleep(1000/10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
