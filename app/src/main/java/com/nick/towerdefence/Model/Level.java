package com.nick.towerdefence.Model;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.nick.towerdefence.R;

public class Level {


    private Cell[][] gameCells;
    private int numOfRows, numOfColumns;

    private Cell gameCell, controlPanelCell;


    // Entities
    private Entity entity;

    public Level (View v, RectF game, RectF controls)
    {
        final View view = v;

        // Set the positions and sizes of the game and control panel cells.
        this.gameCell = new Cell(view.getContext(), game, CellNames.GAMEGRID);
        this.controlPanelCell = new Cell(view.getContext(), controls, CellNames.CONTROL);

        // Get the game grid from the XML file and get the number of rows and columns.
        final GridLayout gameGridLayout = view.findViewById(R.id.gameGridLayout);
        this.numOfRows = gameGridLayout.getRowCount();
        this.numOfColumns = gameGridLayout.getColumnCount();

        // Create game grid.
        this.gameCells = new Cell[this.numOfRows][this.numOfColumns];
        for (int y=0; y<this.numOfRows; y++)
        {
            for (int x=0; x<this.numOfColumns; x++)
            {
                Cell newCell = new Cell(view.getContext(), CellNames.GRIDCELL, x, y);
                this.gameCells[y][x] = newCell;
                gameGridLayout.addView(newCell);
            }
        }


        // Calculate cell size and position, and apply them to the grid.
        final ViewTreeObserver gridObserver = gameGridLayout.getViewTreeObserver();
        gridObserver.addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {

                        final int MARGIN = 2;
                        int pWidth = gameGridLayout.getWidth();
                        int pHeight = gameGridLayout.getHeight();
                        int cols = gameGridLayout.getColumnCount();
                        int rows = gameGridLayout.getRowCount();
                        int w = pWidth/cols;
                        int h = pHeight/rows;

                        for (int y=0; y<rows; y++)
                        {
                            for (int x=0; x<cols; x++)
                            {
                                GridLayout.LayoutParams params = (GridLayout.LayoutParams) gameCells[y][x].getLayoutParams();
                                params.width = w - 2*MARGIN;
                                params.height = h - 2*MARGIN;
                                params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
                                gameCells[y][x].setLayoutParams(params);
                            }
                        }

                        setPath();
                        createEntities(view);

                        gameGridLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                });
    }

    public void createEntities(View v)
    {
        GridLayout gameGridLayout = v.findViewById(R.id.gameGridLayout);

        // Get cell width and height
        int width = gameGridLayout.getWidth() / this.numOfColumns;
        int height = gameGridLayout.getHeight() / this.numOfRows;


        int centerX = (0*width) + (width/2);
        int centerY = (3*height) + (height/2);

        this.entity = new Entity(v.getContext(), centerX, centerY);
        gameGridLayout.addView(this.entity);
    }

    public void setPath()
    {
        this.gameCells[0][2].setCellType(CellNames.WALL);
        this.gameCells[1][2].setCellType(CellNames.WALL);
        this.gameCells[2][2].setCellType(CellNames.WALL);
        this.gameCells[3][2].setCellType(CellNames.WALL);
        this.gameCells[4][2].setCellType(CellNames.WALL);
        this.gameCells[5][2].setCellType(CellNames.WALL);
        this.gameCells[6][2].setCellType(CellNames.WALL);

        this.gameCells[0][4].setCellType(CellNames.WALL);
        this.gameCells[1][4].setCellType(CellNames.WALL);
        this.gameCells[2][4].setCellType(CellNames.WALL);
        this.gameCells[3][4].setCellType(CellNames.WALL);
        this.gameCells[4][4].setCellType(CellNames.WALL);
        this.gameCells[4][5].setCellType(CellNames.WALL);
        this.gameCells[4][6].setCellType(CellNames.WALL);
        this.gameCells[4][7].setCellType(CellNames.WALL);
        this.gameCells[4][8].setCellType(CellNames.WALL);
        this.gameCells[4][9].setCellType(CellNames.WALL);
        this.gameCells[5][9].setCellType(CellNames.WALL);
        this.gameCells[6][9].setCellType(CellNames.WALL);
        this.gameCells[7][9].setCellType(CellNames.WALL);
        this.gameCells[8][9].setCellType(CellNames.WALL);
        this.gameCells[9][9].setCellType(CellNames.WALL);
        this.gameCells[10][9].setCellType(CellNames.WALL);
        this.gameCells[11][9].setCellType(CellNames.WALL);
        this.gameCells[12][9].setCellType(CellNames.WALL);
        this.gameCells[12][8].setCellType(CellNames.WALL);
        this.gameCells[12][7].setCellType(CellNames.WALL);
        this.gameCells[12][6].setCellType(CellNames.WALL);
        this.gameCells[12][5].setCellType(CellNames.WALL);
        this.gameCells[13][5].setCellType(CellNames.WALL);
        this.gameCells[14][5].setCellType(CellNames.WALL);
        this.gameCells[15][5].setCellType(CellNames.WALL);

        this.gameCells[6][3].setCellType(CellNames.WALL);
        this.gameCells[6][4].setCellType(CellNames.WALL);
        this.gameCells[6][5].setCellType(CellNames.WALL);
        this.gameCells[6][6].setCellType(CellNames.WALL);
        this.gameCells[6][7].setCellType(CellNames.WALL);
        this.gameCells[7][7].setCellType(CellNames.WALL);
        this.gameCells[8][7].setCellType(CellNames.WALL);
        this.gameCells[9][7].setCellType(CellNames.WALL);
        this.gameCells[10][7].setCellType(CellNames.WALL);
        this.gameCells[10][6].setCellType(CellNames.WALL);
        this.gameCells[10][5].setCellType(CellNames.WALL);
        this.gameCells[10][4].setCellType(CellNames.WALL);
        this.gameCells[10][3].setCellType(CellNames.WALL);
        this.gameCells[11][3].setCellType(CellNames.WALL);
        this.gameCells[12][3].setCellType(CellNames.WALL);
        this.gameCells[13][3].setCellType(CellNames.WALL);
        this.gameCells[14][3].setCellType(CellNames.WALL);
        this.gameCells[15][3].setCellType(CellNames.WALL);


        this.gameCells[0][3].setCellType(CellNames.PATH);
        this.gameCells[1][3].setCellType(CellNames.PATH);
        this.gameCells[2][3].setCellType(CellNames.PATH);
        this.gameCells[3][3].setCellType(CellNames.PATH);
        this.gameCells[4][3].setCellType(CellNames.PATH);
        this.gameCells[5][3].setCellType(CellNames.PATH);
        this.gameCells[5][4].setCellType(CellNames.PATH);
        this.gameCells[5][5].setCellType(CellNames.PATH);
        this.gameCells[5][6].setCellType(CellNames.PATH);
        this.gameCells[5][7].setCellType(CellNames.PATH);
        this.gameCells[5][8].setCellType(CellNames.PATH);
        this.gameCells[6][8].setCellType(CellNames.PATH);
        this.gameCells[7][8].setCellType(CellNames.PATH);
        this.gameCells[8][8].setCellType(CellNames.PATH);
        this.gameCells[9][8].setCellType(CellNames.PATH);
        this.gameCells[10][8].setCellType(CellNames.PATH);
        this.gameCells[11][8].setCellType(CellNames.PATH);
        this.gameCells[11][7].setCellType(CellNames.PATH);
        this.gameCells[11][6].setCellType(CellNames.PATH);
        this.gameCells[11][5].setCellType(CellNames.PATH);
        this.gameCells[11][4].setCellType(CellNames.PATH);
        this.gameCells[12][4].setCellType(CellNames.PATH);
        this.gameCells[13][4].setCellType(CellNames.PATH);
        this.gameCells[14][4].setCellType(CellNames.PATH);
        this.gameCells[15][4].setCellType(CellNames.PATH);

    }

    public boolean processTouchEvents(MotionEvent event, int layoutID)
    {
        //switch(layoutID) {
        //    case R.id.GameDisplayView: {
        //        if (event.getAction() == MotionEvent.ACTION_DOWN)
        //        {
        //            // Calculate cell position
        //            int row = (int) (event.getX() / (gameGridLayout.getWidth() / this.numOfColumns));
        //            int column = (int) (event.getY() / (gameGridLayout.getHeight() / this.numOfRows));
//
        //            // Find whether a cell is active or inactive, then reverse it.
        //            boolean cellActive = this.gameCells[column][row].getActive();
        //            this.gameCells[column][row].setActive(!cellActive);
        //            gameGridLayout.invalidate();
        //            return true;
        //        }
        //        break;
        //    }
        //    case R.id.GameControlPanel: {
        //        if (event.getAction() == MotionEvent.ACTION_DOWN)
        //        {
        //            //level.TouchEvent(event.getX(), event.getY(), false);
        //            return true;
        //        }
        //        break;
        //    }
        //}
        return false;
    }
}
