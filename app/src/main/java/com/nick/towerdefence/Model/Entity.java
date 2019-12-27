package com.nick.towerdefence.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class Entity {


    private Paint paint;
    private int posX, posY;


    public Entity(int x, int y)
    {
        this.posX = x;
        this.posY = y;
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.RED);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle(500,0,100,this.paint);
    }
}
