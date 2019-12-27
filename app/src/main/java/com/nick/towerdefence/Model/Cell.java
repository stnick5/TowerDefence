package com.nick.towerdefence.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class Cell extends View {

    private CellNames CellType;
    private int dX, dY;

    private boolean gridActive;


    public Cell(Context context, CellNames type, int x, int y) {
        super(context);
        this.CellType = type;
        this.dX = x;
        this.dY = y;
        this.gridActive = false;
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (this.gridActive) { // If grid is ready to draw...
            switch (this.CellType) {
                case GRIDCELL: {
                    canvas.drawColor(Color.LTGRAY);
                    break;
                }
                case WALL: {
                    canvas.drawColor(Color.YELLOW);
                    break;
                }
                case PATH: {
                    canvas.drawColor(Color.WHITE);
                    break;
                }
            }
        }
    }

    public void setCellType(CellNames t) {
        this.CellType = t;
    }

    public CellNames getCellType() {
        return this.CellType;
    }

    public boolean getGridActive() {
        return this.gridActive;
    }

    public void setGridActive(boolean g) {
        this.gridActive = g;
    }
}
