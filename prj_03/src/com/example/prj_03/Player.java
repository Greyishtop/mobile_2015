package com.example.prj_03;



import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Player
{
    /**������ �������� ������*/
    GameView gameView;

    //������
    Bitmap bmp;

    //� � � ���������� �������
    int x;
    int y;

    //�����������
    public Player(GameView gameView, Bitmap bmp)
    {
        this.gameView = gameView;
        this.bmp = bmp;                    //���������� �������

        this.x = 0;                        //������ �� � ���
        this.y = gameView.getHeight() / 2; //������ �� ������
        //this.y = 100;
    }

    //������ ��� ������
    public void onDraw(Canvas c)
    {
        c.drawBitmap(bmp, x, y, null);
    }
}
