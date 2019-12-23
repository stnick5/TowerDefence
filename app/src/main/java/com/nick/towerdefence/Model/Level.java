package com.nick.towerdefence.Model;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;

import com.nick.towerdefence.R;

public class Level {

    private GridLayout gameGridLayout;
    private Cell[][] gameCells;
    private int numOfRows, numOfColumns;

    private Cell gameCell, controlPanelCell;


    public Level (View view, RectF game, RectF controls)
    {
        // Set the positions and sizes of the game and control panel cells.
        this.gameCell = new Cell(view.getContext(), game, CellNames.GAMEGRID);
        this.controlPanelCell = new Cell(view.getContext(), controls, CellNames.CONTROL);

        // Get the game grid from the XML file and get the number of rows and columns.
        this.gameGridLayout = view.findViewById(R.id.gameGridLayout);
        this.numOfRows = this.gameGridLayout.getRowCount();
        this.numOfColumns = this.gameGridLayout.getColumnCount();

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
        this.gameGridLayout.getViewTreeObserver().addOnGlobalLayoutListener(
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
                    }
                });
    }

    public boolean processTouchEvents(MotionEvent event, int layoutID)
    {
        switch(layoutID) {
            case R.id.GameDisplayView: {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    // Calculate cell position
                    int row = (int) (event.getX() / (gameGridLayout.getWidth() / this.numOfColumns));
                    int column = (int) (event.getY() / (gameGridLayout.getHeight() / this.numOfRows));

                    // Find whether a cell is active or inactive, then reverse it.
                    boolean cellActive = this.gameCells[column][row].getActive();
                    this.gameCells[column][row].setActive(!cellActive);
                    gameGridLayout.invalidate();
                    return true;
                }
                break;
            }
            case R.id.GameControlPanel: {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    //level.TouchEvent(event.getX(), event.getY(), false);
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
