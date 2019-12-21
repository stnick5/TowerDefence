package com.nick.towerdefence.Model;

import android.graphics.RectF;

public class Level {

    private Cell gameCell, controlPanelCell;

    public Level (RectF game, RectF controls)
    {
        // Set the positions and sizes of the game and control panel cells.
        gameCell = new Cell(game, CellNames.GAMEGRID);
        controlPanelCell = new Cell(controls, CellNames.CONTROL);
    }
}
