package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class DisplayMessageActivity extends MyActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

    }

    public void onClickPovorot(View v) {
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.myanim1);
        v.startAnimation(anim);
    }

}