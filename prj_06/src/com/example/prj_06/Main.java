package com.example.prj_06;

import android.app.Activity;
import android.os.Bundle;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));

    }
}