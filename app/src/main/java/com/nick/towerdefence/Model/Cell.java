package com.nick.towerdefence.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.view.View;

import com.nick.towerdefence.View.Renderer;

//import static com.nick.towerdefence.Model.CellNames.*;

public class Cell extends Renderer {

    private RectF bounds;
    private CellNames CellType;
    private int dX, dY;

    private boolean isActive;

    public Cell(Context context, RectF b, CellNames type)
    {
        super(context);
        this.bounds = b;
        this.CellType = type;
    }

    public Cell(Context context, CellNames type, int x, int y)
    {
        super(context);
        this.CellType = type;
        this.dX = x;
        this.dY = y;
        this.isActive = false;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //super.onDraw(canvas);
        //switch(this.CellType)
        //{
        //    case GRIDCELL: {
        //        canvas.drawColor(Color.LTGRAY);
        //        break;
        //    }
        //    case WALL: {
        //        canvas.drawColor(Color.YELLOW);
        //        break;
        //    }
        //    case PATH: {
        //        canvas.drawColor(Color.WHITE);
        //        break;
        //    }
        //}
    }

    public void setCellType(CellNames t)
    {
        this.CellType = t;
    }

    public boolean getActive()
    {
        return this.isActive;
    }

    public void setActive(boolean a)
    {
        this.isActive = a;
    }
}
