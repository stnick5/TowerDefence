package com.nick.towerdefence.Controller;

import android.graphics.RectF;
import android.view.View;

import com.nick.towerdefence.Model.Level;
import com.nick.towerdefence.R;

public class GameEngine {

    private Level level;

    public GameEngine(View view)
    {
        float width = view.findViewById(R.id.GameDisplayView).getWidth();
        float height = view.findViewById(R.id.GameDisplayView).getHeight();
        float x = view.findViewById(R.id.GameDisplayView).getX();
        float y = view.findViewById(R.id.GameDisplayView).getY();
        RectF gameRect = new RectF(x, y, width, height);


        float cpWidth = view.findViewById(R.id.GameControlPanel).getWidth();
        float cpHeight = view.findViewById(R.id.GameControlPanel).getHeight();
        float cpx = view.findViewById(R.id.GameControlPanel).getX();
        float cpy = view.findViewById(R.id.GameControlPanel).getY();
        RectF controlRect = new RectF(cpx, cpy, cpWidth, cpHeight);

        level = new Level(gameRect, controlRect);
    }
}
