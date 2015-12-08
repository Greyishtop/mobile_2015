package com.example.prj_03;


import android.content.Intent;
import android.os.Bundle;

public class About extends StartActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Intent intent = getIntent();

    }
}
