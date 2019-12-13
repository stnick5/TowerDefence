package com.nick.towerdefence.Model;

import android.widget.LinearLayout;

public class Level {

    private Cell gameCell, controlPanelCell;

    public Level (LinearLayout game, LinearLayout controls)
    {
        // Set the positions and sizes of the game and control panel cells.
        gameCell = new Cell(game.getX(), game.getY(), game.getWidth(), game.getHeight());
        controlPanelCell = new Cell(controls.getX(), controls.getY(), controls.getWidth(), controls.getHeight());

    }

}
