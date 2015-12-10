package com.example.prj_06;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    MyThread myThread;
    List<Line> myLines;
    Context context;
    LineX lineX;
    LineY lineY;
    LineZ lineZ;
    LineVector lineVector;

    SensorManager sensorManager;
    Sensor sensorAccel;
    StringBuilder sb = new StringBuilder();
    float[] valuesAccel = new float[3];
    float[] valuesAccelMotion = new float[3];
    float[] valuesAccelGravity = new float[3];

    public MySurfaceView(Activity context) {
        super(context);
        this.context = context;
        myLines = new ArrayList<>();
        this.getHolder().addCallback(this);
        sensorManager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        sensorAccel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(listener, sensorAccel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("LOG", "surfaceCreated");
        lineX = new LineX(this);
        lineY = new LineY(this);
        lineZ = new LineZ(this);
        lineVector = new LineVector(this);
        myLines.add(lineX);
        myLines.add(lineY);
        myLines.add(lineZ);
        myLines.add(lineVector);
        myThread = new MyThread(this);
        myThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.d("LOG", "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.d("LOG", "surfaceDestroyed");
        sensorManager.unregisterListener(listener);
    }

    public void render(Canvas canvas) {
        lineVector.setXYZ((int) valuesAccelMotion[0], (int) valuesAccelMotion[1], (int) valuesAccelMotion[2]);
        showInfo();
        for (Line line : myLines) {
            line.render(canvas);
        }
    }

    SensorEventListener listener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            switch (event.sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    for (int i = 0; i < 3; i++) {
                        valuesAccel[i] = event.values[i];
                        valuesAccelGravity[i] = (float) (0.1 * event.values[i] + 0.9 * valuesAccelGravity[i]);
                        valuesAccelMotion[i] = event.values[i] - valuesAccelGravity[i];
                    }
                    break;
            }
        }
    };

    void showInfo() {
        sb.setLength(0);
        sb.append(String.format("%1$.1f\t\t%2$.1f\t\t%3$.1f", valuesAccelMotion[0], valuesAccelMotion[1], valuesAccelMotion[2]));
        Log.d("LOG", sb.toString());
    }
}
