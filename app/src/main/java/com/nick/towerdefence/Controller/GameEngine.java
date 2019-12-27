package com.nick.towerdefence.Controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;

import com.nick.towerdefence.Model.Cell;
import com.nick.towerdefence.Model.CellNames;
import com.nick.towerdefence.Model.Entity;
import com.nick.towerdefence.R;

public class GameEngine extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private View gameView;
    private Context context;

    private Thread gameThread = null;

    private boolean isActive;
    private boolean hasFinishedLoading;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    // Game grid
    private Cell[][] grid;
    private GridLayout gameGrid;
    private int numOfColumns, numOfRows;

    private Entity entity;

    public GameEngine(View view) {
      super(view.getContext());
      this.context = view.getContext();
      this.gameView = view;
      this.surfaceHolder = getHolder();
      this.surfaceHolder.addCallback(this);
      this.paint = new Paint();

      this.isActive = true;
      this.hasFinishedLoading = false;
      loadGrid();
      setPath();
      createEntities();
    }

    @Override
    public void run()
    {
        // If game grid hasn't been enabled, enable it.
        if (!this.hasFinishedLoading) {
            for (int i=0; i<this.grid.length; i++) {
                for (int j=0; j<this.grid[i].length; j++) {
                    this.grid[i][j].setGridActive(true);
                }
            }
            this.hasFinishedLoading = true;
        }

        while (isActive) {
            update();
            this.draw(this.canvas);
            control();
        }
    }

    private void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (surfaceHolder.getSurface().isValid())
        {
            // Lock the canvas
            canvas = surfaceHolder.lockCanvas();

            // Draw stuff

            this.entity.draw(canvas);

            // Unlock the canvas
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        this.isActive = false;
        try {
            //stopping the thread
            gameThread.join();
        } catch (InterruptedException e) {
        }

    }

    public void resume() {
        this.isActive = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void loadGrid() {
        this.gameGrid = this.gameView.findViewById(R.id.gameGridLayout);
        this.numOfRows = this.gameGrid.getRowCount();
        this.numOfColumns = this.gameGrid.getColumnCount();

        // Create the game grid
        this.grid = new Cell[this.numOfRows][this.numOfColumns];
        for (int y=0; y<numOfRows; y++)
        {
            for (int x=0; x<numOfColumns; x++)
            {
                Cell newCell = new Cell(this.context, CellNames.GRIDCELL, x, y);
                this.grid[y][x] = newCell;
                this.gameGrid.addView(newCell);
            }
        }

        // Calculate cell size and position, and apply them to the grid.
        final ViewTreeObserver gridObserver = this.gameGrid.getViewTreeObserver();
        gridObserver.addOnGlobalLayoutListener(
              new ViewTreeObserver.OnGlobalLayoutListener() {
                  @Override
                  public void onGlobalLayout() {
                      final int MARGIN = 2;
                      int pWidth = gameGrid.getWidth();
                      int pHeight = gameGrid.getHeight();
                      int cols = gameGrid.getColumnCount();
                      int rows = gameGrid.getRowCount();
                      int w = pWidth/cols;
                      int h = pHeight/rows;

                      for (int y=0; y<rows; y++)
                      {
                          for (int x=0; x<cols; x++)
                          {
                              GridLayout.LayoutParams params = (GridLayout.LayoutParams) grid[y][x].getLayoutParams();
                              params.width = w - 2*MARGIN;
                              params.height = h - 2*MARGIN;
                              params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
                              grid[y][x].setLayoutParams(params);
                          }
                      }
                      gameGrid.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                  }
              }
        );

    }

    public void setPath() {
        this.grid[0][2].setCellType(CellNames.WALL);
        this.grid[1][2].setCellType(CellNames.WALL);
        this.grid[2][2].setCellType(CellNames.WALL);
        this.grid[3][2].setCellType(CellNames.WALL);
        this.grid[4][2].setCellType(CellNames.WALL);
        this.grid[5][2].setCellType(CellNames.WALL);
        this.grid[6][2].setCellType(CellNames.WALL);

        this.grid[0][4].setCellType(CellNames.WALL);
        this.grid[1][4].setCellType(CellNames.WALL);
        this.grid[2][4].setCellType(CellNames.WALL);
        this.grid[3][4].setCellType(CellNames.WALL);
        this.grid[4][4].setCellType(CellNames.WALL);
        this.grid[4][5].setCellType(CellNames.WALL);
        this.grid[4][6].setCellType(CellNames.WALL);
        this.grid[4][7].setCellType(CellNames.WALL);
        this.grid[4][8].setCellType(CellNames.WALL);
        this.grid[4][9].setCellType(CellNames.WALL);
        this.grid[5][9].setCellType(CellNames.WALL);
        this.grid[6][9].setCellType(CellNames.WALL);
        this.grid[7][9].setCellType(CellNames.WALL);
        this.grid[8][9].setCellType(CellNames.WALL);
        this.grid[9][9].setCellType(CellNames.WALL);
        this.grid[10][9].setCellType(CellNames.WALL);
        this.grid[11][9].setCellType(CellNames.WALL);
        this.grid[12][9].setCellType(CellNames.WALL);
        this.grid[12][8].setCellType(CellNames.WALL);
        this.grid[12][7].setCellType(CellNames.WALL);
        this.grid[12][6].setCellType(CellNames.WALL);
        this.grid[12][5].setCellType(CellNames.WALL);
        this.grid[13][5].setCellType(CellNames.WALL);
        this.grid[14][5].setCellType(CellNames.WALL);
        this.grid[15][5].setCellType(CellNames.WALL);

        this.grid[6][3].setCellType(CellNames.WALL);
        this.grid[6][4].setCellType(CellNames.WALL);
        this.grid[6][5].setCellType(CellNames.WALL);
        this.grid[6][6].setCellType(CellNames.WALL);
        this.grid[6][7].setCellType(CellNames.WALL);
        this.grid[7][7].setCellType(CellNames.WALL);
        this.grid[8][7].setCellType(CellNames.WALL);
        this.grid[9][7].setCellType(CellNames.WALL);
        this.grid[10][7].setCellType(CellNames.WALL);
        this.grid[10][6].setCellType(CellNames.WALL);
        this.grid[10][5].setCellType(CellNames.WALL);
        this.grid[10][4].setCellType(CellNames.WALL);
        this.grid[10][3].setCellType(CellNames.WALL);
        this.grid[11][3].setCellType(CellNames.WALL);
        this.grid[12][3].setCellType(CellNames.WALL);
        this.grid[13][3].setCellType(CellNames.WALL);
        this.grid[14][3].setCellType(CellNames.WALL);
        this.grid[15][3].setCellType(CellNames.WALL);


        this.grid[0][3].setCellType(CellNames.PATH);
        this.grid[1][3].setCellType(CellNames.PATH);
        this.grid[2][3].setCellType(CellNames.PATH);
        this.grid[3][3].setCellType(CellNames.PATH);
        this.grid[4][3].setCellType(CellNames.PATH);
        this.grid[5][3].setCellType(CellNames.PATH);
        this.grid[5][4].setCellType(CellNames.PATH);
        this.grid[5][5].setCellType(CellNames.PATH);
        this.grid[5][6].setCellType(CellNames.PATH);
        this.grid[5][7].setCellType(CellNames.PATH);
        this.grid[5][8].setCellType(CellNames.PATH);
        this.grid[6][8].setCellType(CellNames.PATH);
        this.grid[7][8].setCellType(CellNames.PATH);
        this.grid[8][8].setCellType(CellNames.PATH);
        this.grid[9][8].setCellType(CellNames.PATH);
        this.grid[10][8].setCellType(CellNames.PATH);
        this.grid[11][8].setCellType(CellNames.PATH);
        this.grid[11][7].setCellType(CellNames.PATH);
        this.grid[11][6].setCellType(CellNames.PATH);
        this.grid[11][5].setCellType(CellNames.PATH);
        this.grid[11][4].setCellType(CellNames.PATH);
        this.grid[12][4].setCellType(CellNames.PATH);
        this.grid[13][4].setCellType(CellNames.PATH);
        this.grid[14][4].setCellType(CellNames.PATH);
        this.grid[15][4].setCellType(CellNames.PATH);

    }


    public void createEntities() {
        GridLayout gameGridLayout = this.gameView.findViewById(R.id.gameGridLayout);

        // Get cell width and height
        int width = gameGridLayout.getWidth() / this.numOfColumns;
        int height = gameGridLayout.getHeight() / this.numOfRows;


        int centerX = (0*width) + (width/2);
        int centerY = (3*height) + (height/2);

        this.entity = new Entity(centerX, centerY);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("GameActivity", " Surface Changed.");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("GameActivity", " Surface Destroyed.");
    }


/*
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

    /*@Override
    public boolean onTouch(View v, MotionEvent event) {

        return level.processTouchEvents(event, v.getId());
    }*/

}
