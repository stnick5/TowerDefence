package com.nick.towerdefence.Model;

import android.graphics.RectF;

import static com.nick.towerdefence.Model.CellNames.*;

public class Cell {

    private RectF bounds;
    private CellNames CellType;

    public Cell(RectF b, CellNames type)
    {
        this.bounds = b;
        this.CellType = type;
    }

    public float getX()
    {
        return this.bounds.left;
    }

    public float getY()
    {
        return this.bounds.top;
    }

    public float getWidth()
    {
        return this.bounds.right;
    }

    public float getHeight()
    {
        return this.bounds.bottom;
    }
}
