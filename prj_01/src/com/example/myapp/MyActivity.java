package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends Activity {

    EditText firstNum;
    int prov= 1,fnum = 0,oper = 0;
    Integer res = 0;
 public int getRot(){
     int rot = getWindowManager().getDefaultDisplay().getRotation();
     switch(rot){
         case Surface.ROTATION_0: case Surface.ROTATION_270: return 1;
         case Surface.ROTATION_90: case Surface.ROTATION_180: return 2;
         default: return 1;
     }
 }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getRot()){
            case 1: setContentView(R.layout.main); break;
            case 2: setContentView(R.layout.main2); break;
        }


        firstNum = (EditText) findViewById(R.id.editText);
       /* secondNum = (EditText) findViewById(R.id.editText2);
        result = (EditText) findViewById(R.id.editText3);*/


       /* firstNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prov = 1;
            }
        });

        secondNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prov = 2;
            }
        });*/
    }

    public void onClickNum(View t) {
        if(prov == 2) {
            firstNum.setText("0");
            prov = 1;
        }
        int fnum = Integer.parseInt(firstNum.getText().toString());
        Integer res = 0;
        switch (t.getId()) {
            case R.id.Num1:
                res = fnum * 10 + 1;
                firstNum.setText(res.toString());
                break;
            case R.id.Num2:
                res = fnum * 10 + 2;
                firstNum.setText(res.toString());
                break;
            case R.id.Num3:
                res = fnum * 10 + 3;
                firstNum.setText(res.toString());
                break;
            case R.id.Num4:
                res = fnum * 10 + 4;
                firstNum.setText(res.toString());
                break;
            case R.id.Num5:
                res = fnum * 10 + 5;
                firstNum.setText(res.toString());
                break;
            case R.id.Num6:
                res = fnum * 10 + 6;
                firstNum.setText(res.toString());
                break;
            case R.id.Num7:
                res = fnum * 10 + 7;
                firstNum.setText(res.toString());
                break;
            case R.id.Num8:
                res = fnum * 10 + 8;
                firstNum.setText(res.toString());
                break;
            case R.id.Num9:
                res = fnum * 10 + 9;
                firstNum.setText(res.toString());
                break;
            case R.id.Num0:
                res = fnum * 10;
                firstNum.setText(res.toString());
                break;
            case R.id.buttonC:
                res = fnum / 10;
                firstNum.setText(res.toString());
                break;
            default:
                break;
        }
    }

    public void onPlusClick(View v) {
        if(prov != 2) {
            fnum = Integer.parseInt(firstNum.getText().toString());
            prov = 2;
        }
        else {
            fnum = res;

        }
        firstNum.setText("+");
        oper = 1;

    }

    public void onMinusClick(View v) {
        if(prov != 2) {
            fnum = Integer.parseInt(firstNum.getText().toString());
            prov = 2;
        }
        else {
            fnum = res;
        }
        firstNum.setText("-");
        oper = 2;
    }

    public void onYmnClick(View v) {
        if(prov != 2) {
            fnum = Integer.parseInt(firstNum.getText().toString());
            prov = 2;
        }
        else {
            fnum = res;
        }
        firstNum.setText("*");
        oper = 3;
    }

    public void onDelClick(View v) {
        if(prov != 2) {
            fnum = Integer.parseInt(firstNum.getText().toString());
            prov = 2;
        }
        else {
            fnum = res;
        }
        firstNum.setText("/");
        oper = 4;
    }

    public void onOtClick(View v) {
        int snum = Integer.parseInt(firstNum.getText().toString());

        switch(oper) {
            case 1: res = fnum + snum;firstNum.setText( "=" + res.toString());break;
            case 2: res = fnum - snum;firstNum.setText( "=" + res.toString());break;
            case 3: res = fnum * snum;firstNum.setText( "=" + res.toString());break;
            case 4:
                if (snum != 0) {
                    res = fnum / snum;
                    firstNum.setText( "=" + res.toString());
                }
                else {
                    firstNum.setText( "To infinity and beyond...");
                };
                break;
        }

       // firstNum.setText( "=" + res.toString());
        prov = 2;
    }

    public void sendMessage(View v) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }



}
