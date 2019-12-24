package com.nick.towerdefence.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.nick.towerdefence.View.Renderer;

public class Entity extends Renderer {


    Paint paint = new Paint();

    private int posX, posY;

    public Entity(Context context)
    {
        super(context);
        this.paint = new Paint();
    }

    public Entity(Context context, int x, int y)
    {
        super(context);
        this.posX = x;
        this.posY = y;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.RED);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawCircle(500,0,100,this.paint);

        //canvas.drawPoint(this.posX, this.posY, this.paint);
        //canvas.drawCircle(this.posX, this.posY, 200, this.paint);


    }
}
